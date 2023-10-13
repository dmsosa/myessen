import { useState } from "react"
import Avatar from "../Avatar";
import DropdownItem from "./DropdownItem";
import { FaBeer } from "react-icons/fa"

function DropdownMenu() {
    const [dropdown, setDropdown] = useState(false);
    // const [loggedUser, setAuthState] = useAuth();
    // const { username, image } =  loggedUser || {} ;

    const logout = () => {
        //logoutFunction
    }

    const handleClick = () => {
        setDropdown((prev: boolean) => !prev)
    }

    return (
        <li className="nav-item dropdown">
            <div className="user-pic-div">
                <Avatar alt="username" />
                {"username"}
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
                    url={`/profile/username`}
                    state={"loggedOut"}
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