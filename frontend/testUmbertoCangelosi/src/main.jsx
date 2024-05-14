import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider } from 'react-router-dom'
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.bundle"

import { router } from './routes/routes'


ReactDOM.createRoot(document.getElementById('root')).render(
<RouterProvider router={router}/>
)
