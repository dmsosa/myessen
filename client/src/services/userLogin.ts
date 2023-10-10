import axios, { AxiosPromise, AxiosResponse } from "axios";
import errorHandlerForAxios from "../helpers/handleAxiosError";
import { User } from "../interface/User";
import { LoginResponse } from "../interface/LoginResponse";
import { LoggedResponse } from "../interface/loggedResponse";

async function userLogin({email, password}: {email:string, password:string}): LoggedResponse {
try {    const API = "http://localhost:8080"
    const { data }: AxiosResponse = await axios.post(API+"/auth/login", {
        email: email,
        password: password
    });
   const { user }: {user: LoginResponse} = data;
   const headers = { Authorization: `Token ${user.token}` };
   const loggedIn: LoggedResponse = { headers, isAuth: true, loggedUser: user };
   localStorage.setItem("loggedUser", JSON.stringify(loggedIn));
   return loggedIn;} catch (err) {
    console.log(err)
   }
}

export default userLogin;