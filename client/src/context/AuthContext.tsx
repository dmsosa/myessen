import { createContext, useContext, useState, useEffect } from "react";
import { getUser } from "../services/getUser";
import { TAuthState, TAuthContext } from "../types/AuthTypes";
import { TChildren } from "../types/Children";

const AuthContext = createContext< TAuthContext | null >( null );

export function useAuth() {
    return useContext(AuthContext);
}

var authState: TAuthState = {
    headers: null,
    isAuth: false,
    loggedUser: {
        id: "",
        username: "gener",
        email: "",
        bio: "",
        password: ""
    }
}
const loggedIn: string | null = localStorage.getItem("loggedUser")

if (loggedIn) {
    authState = JSON.parse(loggedIn)
}

export function AuthProvider({ children }: TChildren) {

    const [ { headers, isAuth, loggedUser }, setAuthState ] = useState( authState );

    useEffect( () => {
        if (!headers) { return };

        getUser({ headers }).then((loggedUser) => 
            setAuthState((prev) => ({...prev, loggedUser}))
        ) //token senden, loggedUser erhalten
    }, [headers, setAuthState]);

    return (
        <AuthContext.Provider value={{ authState, setAuthState }}>
            {children} 
        </AuthContext.Provider>
    );
}

export default AuthProvider;