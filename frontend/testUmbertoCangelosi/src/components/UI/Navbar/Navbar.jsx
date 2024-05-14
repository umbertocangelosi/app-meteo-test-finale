import { NavLink } from "react-router-dom";
import { CondizionalButtonService } from "../../../services/CondizionalButtonService";
import { SubscribeButton } from "../Button/SubscribeButton";
import { AuthContext } from "../../../context/AuthContext";
import { useContext } from "react";

export function Navbar() {
  function profilo() {
    const { user } = useContext(AuthContext);

    if (user.isLogged) {
      return (
        <li className="nav-item">
          <NavLink className="nav-link" to="dashboardUtente/">
            Profilo Utente
          </NavLink>
        </li>
      );
    }
  }

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-0 py-3">
      <div className="container-xl">
        <div className="mx-auto" style={{ marginLeft: "20px" }}>
          <h1 className="navbar-brand m-2">App meteo</h1>
        </div>
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarCollapse"
          aria-controls="navbarCollapse"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>

        <div className="collapse navbar-collapse" id="navbarCollapse">
          <div className="navbar-nav mx-lg-auto">
            <NavLink className="nav-link" to="">
              Home
            </NavLink>
            {profilo()}
          </div>
          {/* Right navigation */}
          <CondizionalButtonService />
        </div>
      </div>
    </nav>
  );
}
