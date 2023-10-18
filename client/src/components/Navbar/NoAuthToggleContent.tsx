import { FiArrowDownCircle } from "react-icons/fi";
import SourceCodeLink from "../SourceCodeLink";
import NavItem from "../NavItem";

function NoAuthToggleContent() {
    return (
        <ul className="navbar-nav mr-auto">
            <NavItem classN="active" text="Foods" icon={<FiArrowDownCircle />} url="/" />
            <NavItem text="Login" icon="fa-solid fa-car" url="/" />
            <NavItem text="Register" icon="fa-solid fa-car" url="/" />
            <div className="dropdown-divider"></div>
            <SourceCodeLink classN="nav-link" left/>
            <NavItem classN="nav-link" text="Premium" icon={<FiArrowDownCircle />} url="/"/>
        </ul>
    )
}


export default NoAuthToggleContent;