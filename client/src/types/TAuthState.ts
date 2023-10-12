import { AxiosHeaders } from "axios";
import { User } from "./User";

export type TAuthState = {
    headers: AxiosHeaders | null,
    isAuth: boolean,
    loggedUser: User
}