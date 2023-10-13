import { AxiosHeaders } from "axios";
import { User } from "./User";

export type TAuthState = {
    headers: object | null,
    isAuth: boolean,
    loggedUser: User
}