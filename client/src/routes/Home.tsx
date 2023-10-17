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
                <h2>Was ist los?</h2>
                <Outlet/>
                <LogoutButton></LogoutButton>
            </div>
        </>
    )
}

export default Home;