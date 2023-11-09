import { createBrowserRouter, Navigate } from "react-router-dom";
import ShopPage from "pages/shop";
import HomePage from "pages/home";
import PrivateLayout from "pages/layout/Private/PrivateLayout";
import PublicLayout from "pages/layout/Public/PublicLayout";
import BookDetail from "pages/book";
import Account from "pages/layout/Account";
import Profile from "pages/account/profile";
import AdminLayout from "pages/layout/Admin";
import AllBook from "pages/admin/books";
import ViewBook from "pages/admin/book";
import Cart from "pages/account/cart";
import CheckoutSuccess from "pages/checkout-success";

export const ROUTE_URL = {
  HOME: "/",
  ADMIN: "/admin",
  ACCOUNT: "/account",
  SHOP: "/shop",
  CATEGORY: "/shop/:category",
  BOOK: "/book/:slug",
  PROFILE: "/account/profile",
  CART: "/account/cart",
  ADMIN_BOOKS: "/admin/books",
  ADMIN_VIEW_BOOK: "/admin/book/:id",
  CHECKOUT: "/checkout-success/:id",
};
export const DEFAULT_PAGE = ROUTE_URL.HOME;

export const routes = [
  {
    path: "",
    element: <PublicLayout />,
    children: [
      { path: ROUTE_URL.HOME, element: <HomePage /> },
      { path: ROUTE_URL.SHOP, element: <ShopPage /> },
      { path: ROUTE_URL.CATEGORY, element: <ShopPage /> },
      { path: ROUTE_URL.BOOK, element: <BookDetail /> },
      {
        path: ROUTE_URL.ACCOUNT,
        element: <Navigate to={ROUTE_URL.PROFILE} />,
      },
      {
        path: ROUTE_URL.PROFILE,
        element: (
          <Account>
            <Profile />
          </Account>
        ),
      },
      {
        path: ROUTE_URL.CART,
        element: (
          <Account>
            <Cart />
          </Account>
        ),
      },
      { path: "*", element: <Navigate to={DEFAULT_PAGE} /> },
    ],
  },
  {
    path: ROUTE_URL.ADMIN,
    element: <PrivateLayout />,
    children: [
      {
        path: ROUTE_URL.ADMIN_BOOKS,
        element: (
          <AdminLayout>
            <AllBook />
          </AdminLayout>
        ),
      },
      {
        path: ROUTE_URL.ADMIN_VIEW_BOOK,
        element: (
          <AdminLayout>
            <ViewBook />
          </AdminLayout>
        ),
      },
    ],
  },
  { path: ROUTE_URL.CHECKOUT, element: <CheckoutSuccess /> },
];

export const router = createBrowserRouter(routes);
