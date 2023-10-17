function userLogout() {
    localStorage.removeItem("loggedUser");

    return (
        {
            headers:null,
            isAuth:false,
            loggedUser: {
                id: "",
                username: "loggedOut",
                email: "",
                bio: "",
                password: ""
            }
        }
    )
}

export default userLogout;