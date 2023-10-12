import axios, { AxiosHeaders, AxiosPromise, AxiosRequestHeaders, AxiosResponse } from "axios";
import handleAxiosError from "../helpers/handleAxiosError";
import { LoginResponse } from "../types/LoginResponse";
import { TAuthState } from "../types/TAuthState";

//headers : User info 
//
//

export async function getUser( headers: AxiosHeaders | null ): Promise<TAuthState | null> {
   if (!headers) {
      return null;
   }
   try {
      const login: LoginResponse = await axios(url, { headers: headers });
      const user: TAuthState = { headers, isAuth:true, loggedUser: login };
      return user
   } catch (error) {
      return null;
   }
}
