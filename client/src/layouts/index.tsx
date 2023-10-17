import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, HashRouter, Route, Routes } from "react-router-dom";
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
        <HashRouter>
        <AuthProvider>
          <Routes>
            <Route element={<App />}>
              <Route path="login" element={<Login />}/>
              <Route path="/" element={<Home />}/>
            </Route>
          </Routes>
        </AuthProvider>
        </HashRouter>
      </ThemeProvider>
    </React.StrictMode>
  </QueryClientProvider>,
)
