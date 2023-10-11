import { LoginResponse } from "./LoginResponse";

export type LoggedResponse = {
    headers: object,
    isAuth: boolean,
    loggedUser: LoginResponse
}