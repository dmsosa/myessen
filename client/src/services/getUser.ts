import axios, { AxiosPromise, AxiosRequestHeaders, AxiosResponse } from "axios";
import { LoggedResponse } from "../types/loggedResponse";
import handleAxiosError from "../helpers/handleAxiosError";

async function getUser({ headers }: { headers:AxiosRequestHeaders }): Promise<LoggedResponse> {
   try {
      await axios({ headers, url: "api/user"} )
   } catch (error) {
      
   }
}