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
        <div>
                <button className="navbar-toggler" id="tg" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <a className="nav-link" href="#">Home <span className="sr-only">(current)</span></a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Link</a>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Dropdown
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a className="dropdown-item" href="#">Action</a>
                                <a className="dropdown-item" href="#">Another action</a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link disabled" href="#">Disabled</a>
                        </li>
                    </ul>
                </div>
        </div>
    )
}

export default DropdownMenu;