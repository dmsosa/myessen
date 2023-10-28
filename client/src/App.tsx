import { Outlet } from "react-router-dom";
import Navbar from "./components/Navbar";
import Footer from "./components/Footer";
import React from "react";
import { ThemeContextType, useTheme } from "./context/ThemeContext";


function App() {


  const { theme, setTheme } = useTheme() as ThemeContextType;

  return (
    <React.Fragment>
      <div className={`theme-${theme}`}>
        <header className="header">
          <Navbar/>
        </header>
        <main className="main">
          <Outlet/>
        </main>
        <footer className="footer">
          <Footer/>
        </footer>
      </div>
    </React.Fragment>
  )
}

export default App
