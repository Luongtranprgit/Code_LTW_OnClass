import BookList from "components/BookList/BookList";
import { getBook } from "../home";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Empty } from "antd";

function ShopPage() {
  const { category } = useParams();
  const [books, setBooks] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      if (category) {
        const data = await axios.get(
          `http://localhost:8080/api/books/${category}`
        );

        setBooks(data.data);
      } else {
        const data = await getBook();
        setBooks(data);
      }
    };
    fetchData();
  }, [category]);
  return (
    <div className="shop-page">
      <div className="book-container">
        {books.length > 0 ? (
          <BookList col={4} bookList={books} noFlex />
        ) : (
          <Empty description="Không có sách" />
        )}
      </div>
    </div>
  );
}

export default ShopPage;
