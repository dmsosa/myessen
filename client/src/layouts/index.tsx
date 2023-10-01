import React from "react";
import ReactDOM from "react-dom/client";
import { HashRouter, Route, Routes } from "react-router-dom";
import App from "./App";
import "../utils/index.scss";
import { QueryClientProvider, QueryClient } from '@tanstack/react-query'
import HomeArticles from "../routes/HomeArticles";
import Home from "../routes/Home";


const queryClient = new QueryClient();
ReactDOM.createRoot(document.getElementById("root")!).render(
  <QueryClientProvider client={queryClient}>
    <React.StrictMode>
      <HashRouter>
        <Routes>
          <Route element={<App />}>
            <Route path="/" element={<Home />}>
              <Route index element={<HomeArticles />}/>
            </Route>
          </Route>
        </Routes>
      </HashRouter>
    </React.StrictMode>
  </QueryClientProvider>,
)
