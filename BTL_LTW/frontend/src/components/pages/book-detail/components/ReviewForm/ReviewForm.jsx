import { Rate } from "antd";
import { useState } from "react";
import { useAuthentication } from "store/useAuthentication";
import { useReviewForm } from "../../hooks/useReviewForm";

function ReviewForm({ bookid }) {
  const { register, handleSubmit, errors, onSubmit, setStars } =
    useReviewForm(bookid);
  const { user } = useAuthentication();
  return (
    <form className="review-form" onSubmit={handleSubmit(onSubmit)}>
      <div className="rate">
        <span>Đánh giá số sao*</span>
        <Rate
          allowClear={false}
          allowHalf
          defaultValue={5}
          style={{ fontSize: 16 }}
          onChange={setStars}
        />
      </div>
      <textarea
        {...register("review")}
        className="input-item white"
        placeholder="Đánh giá của bạn*"
      ></textarea>
      {errors.review && <p className="error-text">{errors.review?.message}</p>}
      {user.isLogin && <button className="app-button mg-10">Gửi</button>}
    </form>
  );
}

export default ReviewForm;
