import axios, { AxiosHeaders, AxiosPromise, AxiosRequestHeaders, AxiosResponse } from "axios";
import handleAxiosError from "../helpers/handleAxiosError";
import { LoginResponse } from "../types/LoginResponse";
import { TAuthState } from "../types/TAuthState";
import { User } from "../types/User";

//headers : User info 
//
//

export async function getUser( headers: object | null ): Promise<TAuthState | null> {
   
   const url = "http://localhost:8080"

   if (!headers) {
      return null;
   }

   try {
      const login: LoginResponse = await axios.get(url, { headers: headers });
      const userHeaders: object = { Authentication: "Bearer " + login.token} ; 
      const user: User = login.user;
      return { headers: userHeaders, isAuth:true, loggedUser: user };
      
   } catch (error) {
      return null;
   }
}
