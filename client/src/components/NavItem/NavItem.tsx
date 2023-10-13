import { NavLink } from "react-router-dom";

function NavItem({ icon, text, url, state }: { icon?: any, text?: string, url?: string, state?: any }) {
    const activeClass = ({ isActive }: { isActive:boolean }) => { return `nav-link ${ isActive ? "active":""}` };
    return (
        <li className="nav-item">
            <NavLink className={activeClass} end state={state ? state : ""} to={url ? url : ""}>
                {icon && <i className={icon}></i>} {text ? text : "GenERIKE"}
            </NavLink>
        </li>
    )
}

export default NavItem;