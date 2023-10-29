import userLogout from "../../services/userLogout";
import { useNavigate } from "react-router-dom";

function LogoutButton() {
    const navigate = useNavigate();
    const logout = () => {
        navigate("/login");
        userLogout();
        
    }
    return (
        <div className="logout-area">
            <button className="btn logout-btn btn-danger" onClick={logout}>Logout</button>
        </div>
    )
}

export default LogoutButton;