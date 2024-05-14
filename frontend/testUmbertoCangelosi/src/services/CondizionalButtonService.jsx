import { useContext } from "react";

import { LogoutButton } from "../components/UI/Button/LogoutButton";

import { NotLoggedButtons } from "../components/UI/Button/NotLoggedButtons";
import { AuthContext } from "../context/AuthContext";



export function CondizionalButtonService({ }) {
    const { user } = useContext(AuthContext);
    console.log(user.isLogged)
    return(
        
        user.isLogged ? <LogoutButton /> : <NotLoggedButtons />
    )
}