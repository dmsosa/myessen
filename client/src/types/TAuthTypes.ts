import { User } from "./User";


export type TAuthState = {
    headers: object | null,
    isAuth: boolean,
    loggedUser: User
}

export type TAuthContext = {
    authState: TAuthState,
    setAuthState: React.Dispatch<React.SetStateAction<TAuthState>>;
}
