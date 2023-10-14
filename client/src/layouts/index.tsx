import React from "react";
import ReactDOM from "react-dom/client";
import { HashRouter, Route, Routes } from "react-router-dom";
import { AuthProvider } from "../context/AuthContext";
import App from "./App";
import "../utils/index.scss";
import { QueryClientProvider, QueryClient } from '@tanstack/react-query'
import Home from "../routes/Home";
import Login from "../routes/Login";
import ThemeProvider from "../context/ThemeContext";


const queryClient = new QueryClient();
ReactDOM.createRoot(document.getElementById("root")!).render(
  <QueryClientProvider client={queryClient}>
    <React.StrictMode>
      <ThemeProvider>
      <AuthProvider>
        <HashRouter>
          <Routes>
            <Route element={<App />}>
              <Route path="/" element={<Login />}/>
              <Route path="/login" element={<Home />}/>
            </Route>
          </Routes>
        </HashRouter>
      </AuthProvider>
      </ThemeProvider>
    </React.StrictMode>
  </QueryClientProvider>,
)
