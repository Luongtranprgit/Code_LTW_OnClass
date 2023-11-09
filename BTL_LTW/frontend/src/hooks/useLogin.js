import { REGEX_PASSWORD } from "constant";
import * as yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useAuthentication } from "store/useAuthentication";
import axios from "axios";
import { useContext } from "react";
import { CartContext } from "context/CartContext";

const getUser = async (data) => {
  const user = await axios
    .post("http://localhost:8080/api/user/login", {
      username: "",
      email: data.email,
      pass: data.password,
    })
    .catch((error) => {
      return null;
    });
  return user;
};
export const useLogin = (closeModal) => {
  const { login } = useAuthentication();
  const { fetchData } = useContext(CartContext);
  const schema = yup.object({
    email: yup.string().required("Email không được để trống!"),
    password: yup
      .string()
      .required("Mật khẩu không được để trống!")
      .matches(REGEX_PASSWORD, {
        message: "Mật khẩu phải chứa ít nhất 8 ký tự, 1 chữ cái và 1 số",
      }),
  });
  const {
    register,
    handleSubmit,
    formState: { errors },
    setError,
  } = useForm({
    resolver: yupResolver(schema),
  });
  const onSubmit = async (data) => {
    const res = await getUser(data);
    if (res) {
      const user = {
        email: res.data.email,
        name: res.data.username,
        id: res.data.id,
        role: res.data.userrole,
        avatar: res.data.avatar,
      };
      login(user);
      fetchData(user.id);
      closeModal();
    } else {
      setError("mật khẩu", { message: "Mật khẩu hoặc email sai" });
    }
  };
  return {
    register,
    handleSubmit,
    errors,
    onSubmit,
  };
};
