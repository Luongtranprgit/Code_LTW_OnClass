import { useNavigate } from "react-router-dom";

function SearchItem({ item }) {
  const navigate = useNavigate();
  const toBookDetail = () => {
    navigate(`/book/${item.slug}`);
  };
  return (
    <div className="search-item" onClick={toBookDetail}>
      <img
        src={`http://localhost:8080/api/image/${item.slug}`}
        className="search-item-image"
      />
      <div className="item-desc">
        <h2 style={{ fontSize: "18px" }}>{item.title}</h2>
        <label>
          Tác giả: <p style={{ color: "black" }}>{item.author}</p>
        </label>
        <label>
          Thể loại: <p style={{ color: "black" }}>{item.category}</p>
        </label>
        <label>
          Giá: <p style={{ color: "black" }}>{item.price} VNĐ</p>
        </label>
      </div>
    </div>
  );
}

export default SearchItem;
