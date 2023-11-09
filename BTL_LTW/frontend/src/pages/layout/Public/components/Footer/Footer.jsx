import React from "react";
// import { Container } from "reactstrap";
import { Link } from "react-router-dom";
// import { library } from '@fortawesome/fontawesome-svg-core'
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import { fab } from '@fortawesome/free-solid-svg-icons'

const Footer = () => {
  return (
    <React.Fragment>
      <footer>
        <div className="footer-content">
          <div className="footerBannerBox-container">
            <div className="footerBannerBox light-blue">
              <h3 className="footerBannerBox-title">Mua sách online</h3>
              <p className="">Ở đây chúng tôi hỗ trợ</p>
            </div>
            <div className="footerBannerBox blue">
              <h3 className="footerBannerBox-title">
                Đọc và tìm hiểu sách online
              </h3>
              <p className="">Ở đây chúng tôi hỗ trợ</p>
            </div>
            <div className="footerBannerBox dark-blue">
              <h3 className="footerBannerBox-title">
                Thanh toán hóa đơn trực tuyến
              </h3>
              <p className="">Ở đây chúng tôi hỗ trợ</p>
            </div>
          </div>

          <div className="footerBox-container">
            <div className="footerBox">
              <h3 className="footerBox-title">Book Shop</h3>
              <div className="line"></div>
              <br />
              <p className="c909090 addressItem lh-1.5">Book</p>
              <p className="c909090 addressItem lh-1.5">
                Số 10 Trần Phú Hà Đông <span>+123456789</span>
              </p>
              <p className="c909090 addressItem lh-1.5">
                Số 10 Trần Phú Hà Đông <span>+123 123 123</span>
              </p>
              <p className="c909090 addressItem lh-1.5">
                Số 10 Trần Phú Hà Đông, Việt Nam{" "}
                <span style={{ color: "white" }}>luongtran2k02@gmail.com</span>
              </p>
              <div className="social-container">
                <i className="social-icon fa-brands fa-square-facebook"></i>
                <i className="social-icon fa-brands fa-square-twitter"></i>
                <i className="social-icon fa-brands fa-square-google-plus"></i>
                <i className="social-icon fa-solid fa-square-envelope"></i>
              </div>
            </div>
            <div className="footerBox">
              <h3 className="footerBox-title">Các thể loại sách</h3>
              <div className="line"></div>
              <ul className="footerPost-container">
                <Link style={{ textDecoration: "none" }}>
                  <li className="footerPost-title">
                    Sách thể loại Khoa học viễn tưởng
                  </li>
                </Link>
                <Link style={{ textDecoration: "none" }}>
                  <li className="footerPost-title">Sách thể loại Lãng mạng</li>
                </Link>
                <Link style={{ textDecoration: "none" }}>
                  <li className="footerPost-title">Sách thể loại Hài hước</li>
                </Link>
                <Link style={{ textDecoration: "none" }}>
                  <li className="footerPost-title">Sách thể loại Phiêu lưu</li>
                </Link>
                <Link style={{ textDecoration: "none" }}>
                  <li className="footerPost-title">Sách thể loại Hành động</li>
                </Link>
              </ul>
            </div>
            <div className="footerBox">
              <h3 className="footerBox-title">Tweet mới nhất</h3>
              <div className="line"></div>
              <ul className="footerTweet-container">
                <li className="c909090 mb-3 footerTweet-title">
                  Chúng tôi đã phát hành phiên bản mới (v4.0) của chúng tôi Vui
                  lòng kiểm tra tại #Code Lap Trinh Web{" "}
                </li>
                <li className="c909090 mb-3 footerTweet-title">
                  Chúng tôi đã phát hành phiên bản mới (v4.0) của chúng tôi Vui
                  lòng kiểm tra tại #Code Lap Trinh Web{" "}
                </li>
                <li className="c909090 mb-3 footerTweet-title">
                  Chúng tôi đã phát hành phiên bản mới (v4.0) của chúng tôi Vui
                  lòng kiểm tra tại #Code Lap Trinh Web{" "}
                </li>
              </ul>
            </div>
          </div>
          <div className="copyRight-container c909090">
            © Copyright - <span style={{ color: "#D5D5D5" }}>Book Shop</span> by{" "}
            <span style={{ color: "#D5D5D5" }}>
              Trần Đình Lương - B20DCCN414
            </span>
          </div>
        </div>
      </footer>
    </React.Fragment>
  );
};

export default Footer;
