import { jwtDecode } from "jwt-decode";

import Cookies from "js-cookie";

import React, { useEffect, useState } from "react";
import { AuthContext } from "./AuthContext";

export function AuthContextProvider({ children }) {
  // Stato per gestire le informazioni sull'utente
  const [user, setUser] = useState({
    id:"",
    firstName: "",
    lastName: "",
    email: "",
    citta: "",
    isLogged: false 
    
  });

  useEffect(() => {
    
    const token = Cookies.get("token"); 

    if (token) {
      const decodedToken = jwtDecode(token);
      if (decodedToken) {
        // Se i dati dell'utente sono presenti nel cookie, effettua il login automaticamente
        login(decodedToken);
      }
    }
  }, []);

  // Funzione per effettuare il login
  const login = (decodedToken) => {
    // Simulazione di una richiesta di login
    
    // Dopo aver autenticato l'utente, impostiamo isLogged su true e isAuthorized a seconda del ruolo o dei permessi
    setUser(() => ({
      id:decodedToken.id,
      firstName: decodedToken.nome,
      lastName: decodedToken.cognome,
      email: decodedToken.email,
      citta: decodedToken.citta,
      isLogged: true
      
  
    }));
  };

  // Funzione per effettuare il logout
  const logout = () => {
    // Simulazione di una richiesta di logout
    // Dopo aver eseguito il logout, reimpostiamo isLogged su false e isAuthorized su false
    setUser(() => ({
      id:"",
      firstName: "",
      lastName: "",
      email: "",
      citta: "",
      isLogged: false
      
    }));
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

