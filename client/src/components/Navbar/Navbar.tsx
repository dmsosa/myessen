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
        <div className="sticky-header nav-down" id="sticky-header">
            <section className="bg-color-blue-nav">
                <div className="navbar-overlay"></div>
                <div className="container-lg p-0 px-lg-3" id="mainNavContainer ">
                    <nav className="navbar nav-main navbar-expand-lg nav-main presticked sticky consolas d-lg-none" id="mainNav">
                        <Link className="navbar-brand" to="/">
                            <img src={apple} className="navbar-brand navbar-brand-logo"/>MyEssen
                        </Link>
                        <DropdownMenu/>


                    </nav>
                </div>
            </section>
            <section>
                <div className="navbar nav-main d-none d-lg-block">
                    <h1>Second</h1>
                </div>
            </section>

        </div>
        
    );
}


export default Navbar;