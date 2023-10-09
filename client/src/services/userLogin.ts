// import axios, { AxiosPromise, AxiosResponse } from "axios";
// import errorHandlerForAxios from "../helpers/errorHandlerForAxios";
// import { User } from "../interface/User";

// async function userLogin({username, email, password}: {username:string, email:string, password:string}) {
//     const API = "http://localhost:8080"
//     const  data: AxiosResponse<any> =  await axios.post(API+"/users/login", {
//         username: username,
//         email: email,
//         password: password
//     }).then((res) => {res.data})
//     .catch((error) => {errorHandlerForAxios(error)})
//     const user = data.data
//     const headers = {Authorization: `Token ${user.token}`};
//     const loggedIn = { headers, isAuth: true, loggedUser: user };
//     localStorage.setItem("loggedUser", user);
//     return loggedIn;
// }
