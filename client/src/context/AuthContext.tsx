import { createContext, useContext, useEffect, useState } from "react";
import { getUser } from "../services/getUser";
import { AxiosHeaders } from "axios";

const AuthContext = createContext({});

//type of children
type TChildren = {
    children: JSX.Element | JSX.Element[];
}

var authState = {
    headers: null,
    isAuth: false,
    loggedUser: {
        id: "",
        username: "",
        email: "",
        bio: "",
        password: ""
    }
}

const loggedIn: string | null = localStorage.getItem("loggedUser")

if (loggedIn) {
    authState.loggedUser = JSON.parse(loggedIn)
}

export function AuthContextProvider({ children }: TChildren) {

    const [ { headers, isAuth, loggedUser }, setAuthState ] = useState( authState );

    useEffect( () => {
        getUser({headers})
    }, [headers, setAuthState]);

    return (
        <AuthContext.Provider value={ {headers, isAuth, loggedUser, setAuthState} }>
            { children }
        </AuthContext.Provider>
    )
}