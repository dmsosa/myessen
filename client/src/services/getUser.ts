import axios, { AxiosPromise, AxiosRequestHeaders, AxiosResponse } from "axios";
import { LoggedResponse } from "../interface/loggedResponse";
import handleAxiosError from "../helpers/handleAxiosError";

async function getUser({ headers }: { headers:AxiosRequestHeaders }): Promise<LoggedResponse> {
   return await axios({ headers, url: "api/user"} )
   .then((res) => (res.data))
   .catch((err) => {handleAxiosError(err)})
}