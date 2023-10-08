import { createContext, useContext, useEffect, useState } from "react";
<<<<<<< HEAD
import getUser from 

const AuthContext = createContext('loggedOff');

export function useAuth() {
    return useContext(AuthContext);
}

const logged = localStorage.getItem("loggedUser");
const loggedIn = logged ? JSON.parse(logged): null;
=======

const AuthContext = createContext('loggedOut');

function useAuth() {
    return useContext(AuthContext);
}

const loggedIn = JSON.parse(localStorage.getItem("loggedUser"));

>>>>>>> 5f657b476f182ddde67724bea566a754676bf3df
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
<<<<<<< HEAD
}


=======
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
>>>>>>> 5f657b476f182ddde67724bea566a754676bf3df
