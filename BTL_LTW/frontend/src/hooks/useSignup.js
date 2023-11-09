import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { REGEX_EMAIL, REGEX_PASSWORD } from "constant";
import { message } from "antd";
import axios from "axios";

export const useSignup = () => {
  const [messageApi, contextHolder] = message.useMessage();
  const schema = yup.object({
    name: yup.string().required("Tên không được để trống!"),
    email: yup
      .string()
      .required("Email không được để trống!")
      .matches(REGEX_EMAIL, {
        message: "Email không hợp lệ",
      }),
    password: yup
      .string()
      .required("Mật khẩu không được để trống!")
      .matches(REGEX_PASSWORD, {
        message: "Mật khẩu phải chứa ít nhất 8 ký tự, 1 chữ cái và 1 số",
      }),
    confirm: yup
      .string()
      .required("Mật khẩu xác nhận không được để trống")
      .oneOf([yup.ref("mật khẩu")], "Mật khẩu của bạn không đúng."),
  });
  const {
    register,
    handleSubmit,
    formState: { errors },
    setError,
    reset,
  } = useForm({
    resolver: yupResolver(schema),
  });
  const onSubmit = async (data) => {
    const status = await axios
      .post("http://localhost:8080/api/user", {
        email: data.email,
        username: data.name,
        pass: data.password,
      })
      .catch((error) => {
        setError("email", { message: error.response.data });
      });
    if (status?.status == 200) {
      messageApi.success("Tạo thành công");
      reset();
    }
  };
  return {
    register,
    handleSubmit,
    errors,
    onSubmit,
    contextHolder,
  };
};
