import BookList from "components/BookList/BookList";
import BestSellers from "components/pages/home/BestSellers/BestSellers";
import BookSlide from "components/pages/home/BookSlide/BookSlide";
import axios from "axios";
import { useState, useEffect } from "react";

export const getBook = async () => {
  const res = await axios.get("http://localhost:8080/api/books");
  return res.data;
};
function HomePage() {
  const [books, setBooks] = useState([]);
  const [mostView, setMostView] = useState([]);
  useEffect(() => {
    const fetchData = async () => {
      const data = await getBook();
      setBooks(data);
      const res = await axios.get(
        "http://localhost:8080/api/books/most-viewed"
      );
      setMostView(res.data);
    };
    fetchData();
  }, []);
  return (
    <div className="home-page">
      <div className="new-books">
        <BookSlide books={mostView} />
      </div>
      <div className="home-page_inner">
        <BestSellers />
        <div className="most-viewed">
          <h1>Được nhiều lượt xem nhất</h1>
          <div className="most-viewed_container">
            <BookList col={1} bookList={books.slice(0, 4)} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default HomePage;
