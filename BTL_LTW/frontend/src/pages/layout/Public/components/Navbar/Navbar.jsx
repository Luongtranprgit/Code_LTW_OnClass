import { NavLink } from "react-router-dom";
import { ROUTE_URL } from "routes";

function Navbar() {
  return (
    <div className="public-layout_navbar">
      <div className="navbar-inner">
        <NavLink
          to={ROUTE_URL.HOME}
          className={({ isActive }) =>
            `navbar-item ${isActive ? "active" : ""}`
          }
        >
          Trang Chủ
        </NavLink>
        <NavLink
          to={ROUTE_URL.SHOP}
          className={({ isActive }) =>
            `navbar-item ${isActive ? "active" : ""}`
          }
        >
          Danh sách Sách
        </NavLink>
      </div>
    </div>
  );
}

export default Navbar;
