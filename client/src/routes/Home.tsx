import { Outlet } from "react-router-dom";
import LogoutButton from "../components/Logout/logoutButton";

export const Home = () => {
    return (
        <>
            <div className="text-center mt-5">
                <h1>Hallo Welt</h1>
                <p>
                    Genau dass richtiges
                </p>
                <button className="btn btn-success">Greun</button>
            </div>
            <div className="container">
                <div className="row">
                <h2>Was ist los?</h2>
                <Outlet/>
                <LogoutButton></LogoutButton>
                </div>
                <div className="row"><h1>Another</h1><h2>One</h2><h3>Mehr</h3></div>
            </div>
        </>
    )
}

export default Home;