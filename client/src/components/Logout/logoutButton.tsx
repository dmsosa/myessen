import userLogout from "../../services/userLogout";

function LogoutButton() {
    const logout = () => {
        userLogout()
    }
    return (
        <div className="logout-area">
            <button className="btn logout-btn btn-danger" onClick={logout}>Logout</button>
        </div>
    )
}

export default LogoutButton;