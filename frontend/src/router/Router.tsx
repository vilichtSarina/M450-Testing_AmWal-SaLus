import { BrowserRouter, Route, Routes } from "react-router-dom";
import LoginPage from "../components/pages/LoginPage";
import RegistrationPage from "../components/pages/RegistrationPage";
import TestDetail from "../components/pages/TestPage/TestDetail";

/**
 * Router component renders a route switch with all available pages
 */
const Router = () => {

  /** navigate to different "home"-locations depending on Role the user have */
  return (
    <BrowserRouter>
      <Routes>
        <Route path={"/"} element={<LoginPage />} />
        <Route path={"/login"} element={<LoginPage />} />
        <Route path={"/register"} element={<RegistrationPage />} />
        <Route path={"/test"} element={<TestDetail />} />
      </Routes>
    </BrowserRouter>
  );
};

export default Router;
