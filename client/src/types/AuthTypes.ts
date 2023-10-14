import { ReactNode, Dispatch, SetStateAction } from "react";
import { User } from "./User";

export type TAuthState = {
    headers: object | null,
    isAuth: boolean,
    loggedUser: User
}

export type TAuthContext = {
    authState: TAuthState,
    setAuthState: Dispatch<SetStateAction<TAuthState>>;
}

export type TChildren = {
    children: ReactNode | ReactNode[];
}