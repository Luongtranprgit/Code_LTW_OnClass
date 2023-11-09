import { useContext, useEffect, useState } from "react";
import { BsBagCheckFill } from "react-icons/bs";
import { Link, useParams } from "react-router-dom";
import Logo from "resources/svg/Logo";
import { CartContext } from "context/CartContext";
import Footer from "../layout/Public/components/Footer/Footer";

function CheckoutSuccess() {
  const { id } = useParams();
  const { handleCheckoutSuccess } = useContext(CartContext);
  useEffect(() => {
    handleCheckoutSuccess(id);
  }, []);
  return (
    <div className="success-wrapper">
      <Link to="/" className="logo">
        <Logo />
      </Link>
      <div className="success">
        <p className="icon">
          <BsBagCheckFill />
        </p>
        <h2>Cảm ơn bạn đã đặt hàng!</h2>
        <p className="description">
          Nếu có thắc mắc hãy gửi mail đến địa chỉ mail của tôi
        </p>
        <a className="email" href="mailto:order@example.com">
          luongtran2k02@gmal.com
        </a>
        <Link to="/">
          <button width="300px" className="app-button">
            Tiếp tục mua sách
          </button>
        </Link>
      </div>
      <div className="footer">
        <Footer />
      </div>
    </div>
  );
}

export default CheckoutSuccess;
