import { MainLayout } from "../components/Layout/MainLayout";
import { AuthContextProvider } from "../context/AuthContextProvider";
import { Home } from "../pages/Home";
import { Navigate, createBrowserRouter } from "react-router-dom";
import { Login } from "../pages/Login";

import { Registrazione } from "../pages/Registrazione";
import { DashboardUtente } from "../pages/DashboardUtente";
import { ProtectedRouteByLogin } from "../components/ProtectedRouteByLogin";





export const router = createBrowserRouter([
    {   

        element: (
        <AuthContextProvider>
            <MainLayout/>
        </AuthContextProvider>
        ),
        children: [
            {
                path: "/",
                children: [
                    {
                        path: "",
                        element: <Home/>
                    },  
                    {
                        path: "login/",
                        element: <Login/>
                    },
                    {
                        path: "dashboardUtente/",
                        element: <ProtectedRouteByLogin><DashboardUtente/></ProtectedRouteByLogin>
                    },
                    ,
                    {
                        path: "registrazione/",
                        element: <Registrazione/>
                    },
                    {
                        path: "*",
                        element: <Navigate to="/" />
                    }
                ]
            }
        ]    

    }
]);