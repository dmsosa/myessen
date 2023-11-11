import { FiArrowDownCircle } from "react-icons/fi";
import SourceCodeLink from "../SourceCodeLink";
import NavItem from "../NavItem";
import { Link } from "react-router-dom";
import apple from "../../utils/assets/apple.svg";

function NoAuthToggleContent() {
    return (
        <>
            
            <ul className="navbar-nav nav-main-links">
                <li className="nav-item">
                        <Link className="navbar-brand" to="/">
                            <img src={apple} className="navbar-brand navbar-brand-logo d-lg-none"/>Ma nourriture
                        </Link></li>
            </ul>
            <section className="nav-menu d-block d-lg-none">
                <div className="nav-menu-container container-lg"></div>
                <h1>
                    ei
                </h1>
                <h2>
                    un
                </h2>
                <h3>
                    one
                </h3>
            </section>

        </>
    )
}


export default NoAuthToggleContent;