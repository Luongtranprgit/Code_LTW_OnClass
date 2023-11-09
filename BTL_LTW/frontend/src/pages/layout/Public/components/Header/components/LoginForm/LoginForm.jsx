import FormItem from "components/FormItem/FormItem";
import { useLogin } from "hooks/useLogin";

function LoginForm({ onCloseModal }) {
  const { register, handleSubmit, errors, onSubmit } = useLogin(onCloseModal);

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <FormItem
        label="Email*"
        name="email"
        register={register}
        error={errors.email}
      />
      <FormItem
        label="Mật khẩu*"
        name="password"
        register={register}
        error={errors.password}
        type="password"
      />
      <button
        className="app-button"
        type="submit"
        style={{ background: "#1877f2" }}
      >
        Đăng nhập
      </button>
    </form>
  );
}

export default LoginForm;
