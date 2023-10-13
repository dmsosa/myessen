import { Link } from "react-router-dom";

function DropdownItem( { icon, text, url, handler, state, addClass }: 
    {icon?: any, text?: string, url?: string, handler?:any, state?: any, addClass?: string} ) {
    return (
        <Link 
        className={addClass}
        onClick={handler}
        to={url || "#"}
        state={state}
        >
            {icon} {text}
        </Link>
    )
}

export default DropdownItem;