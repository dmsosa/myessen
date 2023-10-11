import React from "react";
import ReactDOM from "react-dom/client";
import { HashRouter, Route, Routes } from "react-router-dom";
import { AuthContextProvider } from "../context/AuthContext";
import App from "./App";
import "../utils/index.scss";
import { QueryClientProvider, QueryClient } from '@tanstack/react-query'
import Home from "../routes/Home";
import Login from "../routes/Login";


const queryClient = new QueryClient();
ReactDOM.createRoot(document.getElementById("root")!).render(
  <QueryClientProvider client={queryClient}>
    <React.StrictMode>
      <AuthContextProvider>
        <HashRouter>
          <Routes>
            <Route element={<App />}>
              <Route path="/" element={<Login />}/>
              <Route path="/login" element={<Home />}/>
            </Route>
          </Routes>
        </HashRouter>
      </AuthContextProvider>
    </React.StrictMode>
  </QueryClientProvider>,
)
