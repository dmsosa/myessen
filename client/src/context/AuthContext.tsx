import { createContext, useContext, useEffect, useState } from "react";

const AuthContext = createContext('loggedOut');

function useAuth() {
    return useContext(AuthContext);
}

const loggedIn = JSON.parse(localStorage.getItem("loggedUser"));

const authState = {
    headers: null,
    isAuth: false,
    loggedUser: {
        bio: null,
        email: "",
        image: null,
        token: "",
        username: "",
    },
};

function AuthProvider({children}) {
    const [{ headers, isAuth, loggedUser }, setAuthState] = useState( loggedIn || authState, );

    useEffect(() => {
        if (!headers) return;

        getUser
    })

    return (
    <AuthContext.Provider value={}>
        {children}
    </AuthContext.Provider>
    )
}