import { createContext, useContext, useEffect, useState } from "react";

const AuthContext = createContext(null);

const loggedIn = JSON.parse(localStorage.getItem("loggedUser"));

const authState = {
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

export function AuthContextProvider({ children }) {

    const [ { headers, isAuth, loggedUser }, setAuthState ] = useState( loggedIn || authState );

    return (
        <AuthContext.Provider value="null">
            {children}
        </AuthContext.Provider>
    )
}