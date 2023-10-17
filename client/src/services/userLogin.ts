import axios, { AxiosPromise, AxiosResponse } from "axios";
import errorHandlerForAxios from "../helpers/handleAxiosError";

import { LoginResponse } from "../types/LoginResponse";
import { TAuthState } from "../types/TAuthTypes";
import { User } from "../types/User";

async function userLogin({email, password}: {email:string, password:string}): Promise<TAuthState> {
  
    const API = "http://localhost:8080"
    return axios.post(API+"/auth/login", { email: email, password: password})
    .then((data: AxiosResponse<LoginResponse>) => {
        const token:string = data.data.token;
        const user:User = data.data.loggedUser;
        const headers = { authorization: `Bearer ${token}`, username: `${user.username}`};
        const loggedIn = { headers, isAuth: true, loggedUser: user};
        localStorage.setItem("loggedUser", JSON.stringify(loggedIn));
        return loggedIn;
    });
}


export default userLogin;