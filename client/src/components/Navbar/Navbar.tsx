import { Link } from "react-router-dom";
import NavItem from "../NavItem";
import SourceCodeLink from "../SourceCodeLink";
import DropdownMenu from "./DropdownMenu";

function Navbar() {
    return (
        <nav className="navbar navbar-light">
            <div className="container">
                <Link className="navbar-brand" to="/">
                    MyEssen
                </Link>
                <SourceCodeLink left/>

                <ul className="nav navbar-nav pull-xs-right">
                    <NavItem text="Home" icon="fa-solid fa-car" url="/"/>
                    <NavItem text="LogIn" icon="fa-solid fa-user" url="/login"/>
    
                </ul>
                <DropdownMenu />
            </div>
        </nav>
    );
}


export default Navbar;