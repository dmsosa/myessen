import { FiArrowDownCircle } from "react-icons/fi";
import SourceCodeLink from "../SourceCodeLink";
import NavItem from "../NavItem";

function NoAuthToggleContent() {
    return (
        <div className="collapse navbar-collapse" id="navbarSupportedContent" aria-expanded="true">
            <ul className="navbar-nav mr-auto">
                <NavItem text="Login" icon={<FiArrowDownCircle />} url="/login" />
                <NavItem text="Sign In" icon="fa-solid fa-car" url="/" />
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Settings <FiArrowDownCircle/></a>
                    <div className="dropdown-menu">
                        <a className="dropdown-item" href="#">Action</a>
                        <a className="dropdown-item" href="#">Action</a>
                        <a className="dropdown-item" href="#">About us</a>
                    </div>
                </li>
                <div className="dropdown-divider"></div>
                <li className="nav-item"><SourceCodeLink classN="nav-link" left/></li>
                <NavItem classN="disabled" text="Premium" icon={<FiArrowDownCircle />} url="/"/>
            </ul>
        </div>
    )
}


export default NoAuthToggleContent;