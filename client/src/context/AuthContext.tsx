import { ReactNode, createContext, useContext, useState, useEffect } from "react";
import { getUser } from "../services/getUser";
import { TAuthContext, TAuthState } from "../types/TAuthTypes";

//Types for unsere Kontext


//End Types

//Kontext erstellen
const AuthContext = createContext< TAuthContext | null >( null );

export function useAuth() {
    return useContext(AuthContext);
}

//End Kontext erstellen

var authState: TAuthState = {
    headers: null,
    isAuth: false,
    loggedUser: {
        id: "",
        username: "no-user",
        email: "",
        bio: "",
        password: ""
    }
}
const loggedIn: string | null = localStorage.getItem("loggedUser")

if (loggedIn) {
    authState = JSON.parse(loggedIn)
}

//KontextProvider erstellen
export function AuthProvider({ children }: { children: ReactNode | ReactNode[] }) {
    console.log(authState);
    const [ { headers, isAuth, loggedUser }, setAuthState ] = useState( authState );

    useEffect( () => {
        if (headers === null) { return };
        getUser( headers ).then((loggedUser) => 
            setAuthState((prev) => ({...prev, loggedUser}))
        ) //token senden, loggedUser erhalten
    }, [headers, setAuthState]);

    return (
        <AuthContext.Provider value={{ authState, setAuthState }}>
            {children} 
        </AuthContext.Provider>
    );
}
//End KontextProvier

//Export
export default AuthProvider;