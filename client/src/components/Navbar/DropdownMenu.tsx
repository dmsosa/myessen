import { useState } from "react"
import { useAuth } from "../../context/AuthContext";
import Avatar from "../Avatar";
import DropdownItem from "./DropdownItem";
//Icons & Assets
import { FaBeer } from "react-icons/fa"

function DropdownMenu() {
    const [dropdown, setDropdown] = useState(false);
    const  context  = useAuth();
    const loggedUser = context?.authState.loggedUser;
    const setAuthState = context?.setAuthState;

    const logout = () => {
        //logoutFunction
    }

    const handleClick = () => {
        setDropdown((prev: boolean) => !prev)
    }

    return (
        <li className="nav-item dropdown col">
            <div className="user-pic-div">
                <Avatar alt={loggedUser ? loggedUser.username : "nonuser"} />
                {loggedUser ? loggedUser.username : "nonuser"}
            </div>
            <div 
            className="nav-link dropdown-toggle cursor-pointer"
            onClick={handleClick}
            >
                <button>Drop</button>
            </div>
            <div 
                className="dropdown-menu"
                style={{display: dropdown ? "block" : "none"}}
                onClick={handleClick}
            >
                <DropdownItem
                    icon={<FaBeer />}
                    text="Profile"
                    url={`/profile/${loggedUser? loggedUser.username : "nonuser"}`}
                    state={context?.authState.isAuth ? "loggedIn":"loggedOut"}
                    />
                <div className="dropdown divider"><hr></hr></div>
                <DropdownItem icon={<FaBeer />} text="Settings" url="/settings" addClass="settings"/>
                <div className="dropdown divider"><hr></hr></div>
                <DropdownItem icon={<FaBeer />} text="Logout" url="#"  handler={logout} addClass="logout"/>
            </div>
        </li>
    )
}

export default DropdownMenu;