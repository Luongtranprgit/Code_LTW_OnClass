import { Empty } from "antd";
import CartItem from "components/pages/account/components/CartItem";
import { CartContext } from "context/CartContext";
import { useContext } from "react";
import { round } from "utils";

function Cart() {
  const { cartItems, totalPrice, handleCheckout } = useContext(CartContext);

  return (
    <div className="cart">
      <div className="cart-item-container">
        {cartItems.length > 0 ? (
          cartItems.map((item) => <CartItem item={item} key={item.id} />)
        ) : (
          <Empty image={Empty.PRESENTED_IMAGE_SIMPLE} />
        )}
      </div>
      <div className="total">
        <div className="total-amount">
          <h2>Tổng tiền:</h2>{" "}
          <h1 className="amount">{round(totalPrice, 2)} VNĐ</h1>
        </div>
        <button className="app-button" onClick={handleCheckout}>
          <span>Thanh Toán</span>
        </button>
      </div>
    </div>
  );
}

export default Cart;
