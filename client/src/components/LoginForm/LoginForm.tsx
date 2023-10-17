import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";
import { TAuthContext } from "../../types/TAuthTypes";
import userLogin from "../../services/userLogin";
import FormFieldSet from "../FormFieldSet";

function LoginForm() {

    const [form, setForm] = useState({email: "", password: ""});
    const { setAuthState } = useAuth() as TAuthContext;
    const navigate = useNavigate();

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        const { email, password } = form;
        userLogin({ email, password })
        .then((loggedUser) => setAuthState(loggedUser))
        .then( () => navigate("/"))
        console.log("retrieving login")
    };

    const inputHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
        const name = e.target.name;
        const value = e.target.value;
        setForm((form) => ({...form, [name]: value}));
        console.log(form)
    };


    return (
        <form onSubmit={handleSubmit}>
            <FormFieldSet
                type="email"
                name="email"
                required
                placeholder="Email"
                value={form.email}
                handler={inputHandler}
                normal
                minLength={3}
                autoFocus   
            ><></></FormFieldSet>
            <FormFieldSet
                type="password"
                name="password"
                required
                placeholder="Password"
                value={form.password}
                handler={inputHandler}
                normal
                minLength={3}
                autoFocus   
            ><></></FormFieldSet>
            <button
                className="btn btn-lg btn-primary pull-xs-right"
            >Login</button>
        </form>
    );
};
export default LoginForm;