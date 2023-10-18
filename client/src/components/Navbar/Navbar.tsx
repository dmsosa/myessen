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
        localStorage.setItem("default-theme3e", isCurrentDark ? "light" : "dark" );
    }

    /* <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent"> */
    return (
        <nav className="navbar navbar-expand-lg">
                <Link className="navbar-brand" to="/">
                    <img src={apple} className="navbar-brand-logo"/>MyEssen
                </Link>
                <DropdownMenu />

        </nav>
    );
}


export default Navbar;