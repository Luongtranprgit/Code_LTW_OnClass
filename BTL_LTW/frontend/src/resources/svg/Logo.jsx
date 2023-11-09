import React from "react";

function Logo() {
  return (
    <div
      className="logoText"
      style={{ display: "flex", width: "100%", fontFamily: "Sora" }}
    >
      <div className="logoH" style={{ borderRadius: "50%" }}>
        <img
          className="imgH"
          src="https://bom.so/3qgVsN"
          alt="Logo"
          style={{ width: "50px", height: "50px", borderRadius: "50%" }}
        />
      </div>
      <div
        className="TextH"
        style={{
          alignSelf: "center",
          marginLeft: "10px",
          fontSize: "18px",
          fontWeight: "bold",
          color: "#f18121",
        }}
      >
        Book Shop
      </div>
    </div>
  );
}

export default Logo;
