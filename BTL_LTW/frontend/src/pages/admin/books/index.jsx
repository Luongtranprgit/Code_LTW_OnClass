import { Table, message, Popconfirm } from "antd";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

function AllBook() {
  const [messageApi, contextHolder] = message.useMessage();
  const [bookList, setBookList] = useState([]);
  const handleDelete = async (id) => {
    console.log(id);
    const res = await axios.post(`http://localhost:8080/api/book/delete/${id}`);
    console.log(res);
    if (res.data == "200") {
      message.success("Xóa thành công!");
    } else {
      message.error("Xóa thất bại!");
    }
  };
  useEffect(() => {
    const fetchData = async () => {
      const data = await axios.get("http://localhost:8080/api/books");
      setBookList(data.data);
    };
    fetchData();
  }, []);
  const bookColumn = [
    {
      title: "ID",
      dataIndex: "id",
      key: "id",
      render: (val, record, index) => index + 1,
    },
    {
      title: "Tiêu đề",
      dataIndex: "title",
      key: "title",
    },
    {
      title: "Tác giả",
      dataIndex: "author",
      key: "author",
    },
    {
      title: "Giá",
      dataIndex: "price",
      key: "price",
    },
    {
      title: "Thể loại",
      dataIndex: "category",
      key: "category",
    },
    {
      title: "Số sao đánh giá",
      dataIndex: "stars",
      key: "stars",
    },
    {
      title: "Hành động",
      key: "action",
      render: (_, record) => {
        const user = JSON.parse(localStorage.getItem("bookory-user"));

        if (user?.isLogin)
          return (
            <div className="column-action">
              <Link
                to={`/admin/book/${record.id}`}
                className="column-action-btn"
                style={{
                  border: "1px solid #28a745",
                  backgroundColor: "#28a745",
                  padding: ".375rem .75rem",
                  borderRadius: ".25rem",
                  color: "white",
                  textDecoration: "none",
                }}
              >
                View
              </Link>
              <Popconfirm
                title="Bạn muốn xóa cuốn sách này?"
                onConfirm={() => {
                  handleDelete(record.id);
                }}
                onCancel={() => {
                  messageApi.info("Hủy xóa");
                }}
                okText="Có"
                cancelText="Không"
              >
                <span
                  className="column-action-btn delete"
                  style={{
                    border: "1px solid #dc3545",
                    backgroundColor: "#dc3545",
                    padding: ".375rem .75rem",
                    borderRadius: ".25rem",
                    color: "white",
                    textDecoration: "none",
                  }}
                >
                  Delete
                </span>
              </Popconfirm>
            </div>
          );
        return "";
      },
    },
  ];
  return (
    <div className="all-book">
      {contextHolder}
      {/* <h1>Thêm sách mới</h1>
      <Link
        to="/admin/book/-1"
        className="app-button"
        style={{ backgroundColor: " #007bff", marginBottom: "2%" }}
      >
        <span>Add Book</span>
      </Link> */}
      <h1>Danh sách tất cả các sách</h1>
      <Table columns={bookColumn} dataSource={bookList} />
    </div>
  );
}

export default AllBook;
