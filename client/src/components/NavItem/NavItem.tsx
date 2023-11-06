import { NavLink } from "react-router-dom";

function NavItem({icon, text, url, state, classN }: { icon?: any, text?: string, url?: string, state?: any , classN?: string | null}) {
    const activeClass = ({ isActive }: { isActive:boolean }) => { return `nav-link ${ isActive ? "active":""}` };
    const itemClass = classN ? "nav-item " + classN : "nav-item";
    return (
        <li className={itemClass}>
            <NavLink className={activeClass} end state={state ? state : ""} to={url ? url : ""}>
                {icon && <i className={icon}></i>} {text ? text : "GenERIKE"}
            </NavLink>
        </li>
    )
}

export default NavItem;