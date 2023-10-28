import { FiArrowDownCircle } from "react-icons/fi";
import SourceCodeLink from "../SourceCodeLink";
import NavItem from "../NavItem";
import { User } from "../../types/User";

function AuthToggleContent({ loggedUser }: { loggedUser: User | undefined }) {
    return (
        <div className="collapse navbar-collapse" id="navbarSupportedContent" aria-expanded="true">
            <ul className="navbar-nav mr-auto">
                <NavItem text="Foods" icon={<FiArrowDownCircle />} url="/" />
                <NavItem text={loggedUser?.username} icon="fa-solid fa-car" url="/" />
                <li className="nav-item dropdown">
                    <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Settings <FiArrowDownCircle/></a>
                    <div className="dropdown-menu">
                        <a className="dropdown-item" href="#">Account</a>
                        <a className="dropdown-item" href="#">Country</a>
                        <a className="dropdown-item" href="#">Theme</a>
                    </div>
                </li>
                <div className="dropdown-divider"></div>
                <li className="nav-item"><SourceCodeLink classN="nav-link" left/></li>
                <NavItem classN="disabled" text="Premium" icon={<FiArrowDownCircle />} url="/"/>
            </ul>
        </div>
    )
};

export default AuthToggleContent;