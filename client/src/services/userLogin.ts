import axios, { AxiosPromise, AxiosResponse } from "axios";
import errorHandlerForAxios from "../helpers/handleAxiosError";

import { LoginResponse } from "../types/LoginResponse";
import { TAuthState, TAuthContext } from "../types/TAuthTypes";
import { User } from "../types/User";
import { useAuth, } from "../context/AuthContext";

async function userLogin({login, password}: {login:string, password:string}): Promise<TAuthState> {

    const API = "http://localhost:8080"
    return axios.post(API+"/auth/login", { login: login, password: password})
    .then((data: AxiosResponse<LoginResponse>) => {
        const token:string = data.data.token;
        const user:User = data.data.loggedUser;
        const headers = { authorization: `Bearer ${token}`, username: `${user.username}`};
        const loggedIn = { headers, isAuth: true, loggedUser: user};
        localStorage.setItem("loggedUser", JSON.stringify(loggedIn));
        console.log(loggedIn);
        return loggedIn;
    });
}


export default userLogin;