import { Link } from "react-router-dom";
import NavItem from "../NavItem/NavItem";


function Navbar() {
    return (
        <>
            <nav className="navbar navbar-light">
                <div className="container">
                    <NavItem />
                    <Link className="navbar-brand" to="/">MyEssen</Link>
                </div>
                <h1>Schon genug</h1>
            </nav>
        </>
    )
}


export default Navbar;