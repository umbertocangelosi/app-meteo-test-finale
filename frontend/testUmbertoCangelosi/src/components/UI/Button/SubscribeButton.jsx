import React from 'react';
import { NavLink } from 'react-router-dom';

export const SubscribeButton = ({ disabled }) => {
  return (
    <div>
    <NavLink className="btn btn-primary" to="registrazione/">
      Registrazione
    </NavLink>
  </div>
  );
};

