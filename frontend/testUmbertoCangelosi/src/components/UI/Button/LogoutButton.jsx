
import React, { useContext } from 'react';

import {useNavigate } from 'react-router-dom';
import Cookies from 'js-cookie';
import { AuthContext } from '../../../context/AuthContext';


export const LogoutButton = () => {
  const { logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    // Resettare lo stato dell'utente a valori vuoti e isAuthorized a false
    logout();

    // Rimuovere il token salvato nei cookie
    Cookies.remove('token');

    navigate('login/');
  };

  return( 
    <>
    <button onClick={handleLogout} className="btn btn-warning">Logout</button>
    </>
  );
};


