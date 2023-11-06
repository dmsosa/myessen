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
        <>
        <div className="toggler-container d-lg-none d-inline-flex justify-content-end position-relative mv-0">
            <button className="navbar-toggler nav-main-collapse d-lg-none d-inline-flex" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
            </button>
        </div>
        <div className="collapse navbar-collapse navbar-collapse-main navbar-indicator collapse show" id="navbarSupportedContent">
            {isAuth?  <AuthToggleContent loggedUser={loggedUser} /> : <NoAuthToggleContent />}
        </div>
        </>

    )
}

export default DropdownMenu;