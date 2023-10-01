import { Outlet } from "react-router-dom";

export const Home = () => {
    return (
        <>
            <div className="text-center mt-5">
                <h1>Hallo Welt</h1>
                <p>
                    Genau dass richtiges
                </p>
                <button className="btn btn-success">Grun</button>
            </div>
            <div className="container">
                <h2>Was ist los?</h2>
                <Outlet/>
            </div>
        </>
    )
}

export default Home;