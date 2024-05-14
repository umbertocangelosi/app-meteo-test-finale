import React from "react";
import { NavLink } from "react-router-dom";

export const LoginButton = () => {
  return (
    <>
      <div >
        <NavLink to="/login">
          <button className="btn btn-light m-3">Login</button>
        </NavLink>
      </div>
    </>
  );
};
