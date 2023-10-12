import axios, { AxiosPromise, AxiosResponse } from "axios";
import errorHandlerForAxios from "../helpers/handleAxiosError";

import { LoginResponse } from "../types/LoginResponse";
import { LoggedResponse } from "../types/TAuthState";
import { User } from "../types/User";

async function userLogin({email, password}: {email:string, password:string}): AxiosPromise<LoggedResponse> {
  
    const API = "http://localhost:8080"
    return axios.post(API+"/auth/login", {
        email: email,
        password: password
    }).then((data: AxiosResponse<LoginResponse>) => {
        const token:string = data.data.token;
        const user:User = data.data.user;
        const headers = { Authentication: `Bearer ${token}`};
        localStorage.setItem("loggedUser", JSON.stringify(user));
        return { headers, isAuth: true, loggedUser: user };
    });
}


export default userLogin;