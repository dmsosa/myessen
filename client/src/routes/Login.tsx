import LoginForm from "../components/LoginForm";

export const Login = () => {

    return (
        <>
            <div className="text-center mt-5">
                <h1> Name</h1>
                <input className="input" type="text" placeholder="Geben Sie dein Name, bitte"/>
                <button className="btn btn-success">Login</button>
                <button className="btn disabled">Di</button>
                <button className="btn btn-info">Sign In</button>
            </div>
            <LoginForm></LoginForm>
        </>
       
    )
}

export default Login;