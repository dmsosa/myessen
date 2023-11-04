import { useState } from "react"
import { useAuth } from "../../context/AuthContext";
import Avatar from "../Avatar";
import DropdownItem from "./DropdownItem";
//Icons & Assets
import { FaBeer } from "react-icons/fa"
import AuthToggleContent from "./AuthToggleContent";
import NoAuthToggleContent from "./NoAuthToggleContent";

function DropdownMenu() {
    const [dropdown, setDropdown] = useState(false);
    const  context  = useAuth();
    const loggedUser = context?.authState.loggedUser;
    const isAuth = context?.authState.isAuth;
    const setAuthState = context?.setAuthState;

    const logout = () => {
        //logoutFunction
    }

    const handleClick = () => {
        setDropdown((prev: boolean) => !prev)
    }

    return (
        <div className="toggler-container">
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
                <span className="navbar-toggler-icon"></span>
            </button>
            {isAuth?  <AuthToggleContent loggedUser={loggedUser} /> : <NoAuthToggleContent />}
        </div>
    )
}

export default DropdownMenu;