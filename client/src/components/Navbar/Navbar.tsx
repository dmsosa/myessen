import { Link } from "react-router-dom";
import NavItem from "../NavItem";
import SourceCodeLink from "../SourceCodeLink";
import DropdownMenu from "./DropdownMenu";
import { ThemeContextType, useTheme } from "../../context/ThemeContext";
import { useAuth } from "../../context/AuthContext";
import { TAuthContext } from "../../types/TAuthTypes";
import { FiArrowDownCircle } from "react-icons/fi";
import apple from "../../utils/assets/apple.svg";

function Navbar() {
    const {theme, setTheme} = useTheme() as ThemeContextType;
    const { authState } = useAuth() as TAuthContext;
    const { isAuth } = authState;
    const handleTheme = () => {
        const isCurrentDark = theme === "dark";
        setTheme( isCurrentDark ? "light" : "dark" );
        localStorage.setItem("default-theme3e", isCurrentDark ? "light" : "dark" );
    }

    return (
        <nav className="navbar">
            <div className="container navbar-container">
                <Link className="navbar-brand col" to="/">
                    <img src={apple} className="navbar-brand-logo"/>MyEssen
                </Link>
                <SourceCodeLink left/>
                {isAuth && (<>
                <NavItem text="New Article" icon={<FiArrowDownCircle />} url="/"/>
                <DropdownMenu />
                </>)}
                {!isAuth && (<ul className="nav navbar-nav pull-xs-right">
                    <NavItem text="Home" icon="fa-solid fa-car" url="/"/>
                    <NavItem text="LogIn" icon="fa-solid fa-user" url="/login"/>
                </ul>)}

                
                <div className="switcher-area col">
                    <div className="switcher">
                        <input 
                        className="switcher-checkbox" 
                        type="checkbox" 
                        checked={theme === "dark"}
                        readOnly
                        />
                        <button className="switcher-btn" onClick={handleTheme}>Switch</button>
                    </div>
                </div>
            </div>
        </nav>
    );
}


export default Navbar;