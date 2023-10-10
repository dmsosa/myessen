import { LoginResponse } from "./LoginResponse";

export interface LoggedResponse {
    headers: object,
    isAuth: boolean,
    loggedUser: LoginResponse
}