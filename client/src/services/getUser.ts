import axios, { AxiosHeaders, AxiosPromise, AxiosRequestHeaders, AxiosResponse } from "axios";
import handleAxiosError from "../helpers/handleAxiosError";
import { User } from "../types/User";

//headers : User info 
//
//

export async function getUser( headers: object ): Promise<User> {
   
   const url = "http://localhost:8080"
   try {
      const { data } = await axios.get(url+"api/user", { headers: headers });
      return data.loggedUser;
      
   } catch (error) {
      throw Error("Kein Benutzer")
   }
}
