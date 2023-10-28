import { Link } from "react-router-dom";
import { ThemeContextType, useTheme } from "../../context/ThemeContext";
import { useAuth } from "../../context/AuthContext";
import { TAuthContext } from "../../types/TAuthTypes";
import apple from "../../utils/assets/apple.svg";
import AuthToggleContent from "./AuthToggleContent";
import NoAuthToggleContent from "./NoAuthToggleContent";
import DropdownMenu from "./DropdownMenu";

function Navbar() {
    const {theme, setTheme} = useTheme() as ThemeContextType;
    const { authState } = useAuth() as TAuthContext;
    const { isAuth } = authState;
    const handleTheme = () => {
        const isCurrentDark = theme === "dark";
        setTheme( isCurrentDark ? "light" : "dark" );
        localStorage.setItem("default-theme", isCurrentDark ? "light" : "dark" );
    }


    return (
        
        <nav className="navbar navbar-expand-lg nav-main">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">
                    <img src={apple} className="navbar-brand-logo"/>MyEssen
                </Link>
                <DropdownMenu />
            </div>
        </nav>
    );
}


export default Navbar;