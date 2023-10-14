import { Link } from "react-router-dom";
import NavItem from "../NavItem";
import SourceCodeLink from "../SourceCodeLink";
import DropdownMenu from "./DropdownMenu";
import { useTheme } from "../../context/ThemeContext";
import { ThemeContextType } from "../../types/ThemeTypes";


function Navbar() {
    const {theme, setTheme} = useTheme() as ThemeContextType;
    const handleChange = () => {

        if (theme === "light") {
            setTheme("dark");
        } else {
            setTheme("light");
        }
    }

    return (
        <nav className="navbar navbar-light">
            <div className="container">
                <Link className="navbar-brand" to="/">
                    MyEssen
                </Link>
                <SourceCodeLink left/>
                <input type="checkbox" id="dark" data-theme={theme} onClick={handleChange}/><label>{theme}</label>
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