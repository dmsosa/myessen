import { createContext, useContext, useEffect, useState } from "react";
import getUser from 

const AuthContext = createContext('loggedOff');

export function useAuth() {
    return useContext(AuthContext);
}

const logged = localStorage.getItem("loggedUser");
const loggedIn = logged ? JSON.parse(logged): null;
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
}


