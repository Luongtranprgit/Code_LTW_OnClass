import { Avatar, Badge, Dropdown } from "antd";
import { avatarList, categories } from "constant";
import { useContext, useState } from "react";
import { IoAppsOutline, IoBagOutline } from "react-icons/io5";
import { Link, useNavigate } from "react-router-dom";
import Logo from "resources/svg/Logo";
import { ROUTE_URL } from "routes";
import { CartContext } from "context/CartContext";
import { useAuthentication } from "store/useAuthentication";
import LoginModal from "./components/LoginModal/LoginModal";
import SearchTool from "components/SearchTool";

function Header() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const { user, logout } = useAuthentication();
  const { totalQuantities } = useContext(CartContext);
  const navigate = useNavigate();

  const userItems = [
    {
      key: "1",
      label: (
        <Link to={ROUTE_URL.ACCOUNT} className="user-dropdown-item">
          Tài khoản của tôi
        </Link>
      ),
    },
    {
      key: "2",
      label: (
        <div
          className="user-dropdown-item"
          onClick={() => {
            logout();
            navigate(ROUTE_URL.HOME);
          }}
        >
          Đăng xuất
        </div>
      ),
    },
  ];
  const adminItems = [
    {
      key: "1",
      label: (
        <Link to={ROUTE_URL.ADMIN_BOOKS} className="user-dropdown-item">
          Quản lí thông tin
        </Link>
      ),
    },
    {
      key: "2",
      label: (
        <div
          className="user-dropdown-item"
          onClick={() => {
            logout();
            navigate(ROUTE_URL.HOME);
          }}
        >
          Đăng xuất
        </div>
      ),
    },
  ];
  const items = categories.map((item) => {
    const Icon = item.icon;
    return {
      label: (
        <div className="categories-item">
          <Link to="">
            <Icon className="categories-item-icon" />
            <span>{item.name}</span>
          </Link>
        </div>
      ),
      key: item.id,
    };
  });
  return (
    <div className="public-layout_header" style={{ background: "lightblue" }}>
      <div className="public-layout_header-inner">
        <Link to="/">
          <Logo />
        </Link>
        <div className="category-search">
          <Dropdown
            menu={{
              items,
              onClick: (item) => {
                const index = parseInt(item.key);
                navigate(`/shop/${categories[index - 1].name}`);
              },
            }}
            arrow={{ pointAtCenter: true }}
            placement="bottom"
          >
            <div
              className="category app-button"
              style={{ background: "blue", width: "180px" }}
            >
              <IoAppsOutline />
              <span>Thể loại</span>
            </div>
          </Dropdown>
          <SearchTool />
        </div>
        <div className="user">
          {user.isLogin ? (
            <div className="user-menu">
              <Dropdown
                menu={{ items: user.role == "user" ? userItems : adminItems }}
                arrow={{ pointAtCenter: true }}
                placement="bottomRight"
                trigger={["click"]}
              >
                <div className="user-menu-item">
                  <Avatar src={avatarList[user.avatar - 1]} size={48} />
                </div>
              </Dropdown>
              {user.role == "user" && (
                <Badge count={totalQuantities}>
                  <Link to={ROUTE_URL.CART} className="user-menu-item">
                    <IoBagOutline />
                  </Link>
                </Badge>
              )}
            </div>
          ) : (
            <button
              className="login app-button"
              onClick={() => {
                setIsModalOpen(true);
              }}
            >
              Đăng nhập
            </button>
          )}
        </div>
        <LoginModal open={isModalOpen} setOpen={setIsModalOpen} />
      </div>
    </div>
  );
}

export default Header;
