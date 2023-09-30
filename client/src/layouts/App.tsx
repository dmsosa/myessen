import { useState } from 'react';
import '../utils/App.scss';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import {Home} from '../pages/home';
import {Beispiel} from '../pages/beispiel';
import Container from 'react-bootstrap/Container';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Card } from '../components/cards/Card';
import { Header } from '../components/header/Header';
import {useFoodData} from '../hooks/useFoodData'

function App() {
  const data = useFoodData();
  return (
    <>
      <BrowserRouter basename={""}>
        <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/beispiel" element={<Beispiel/>}/>
        </Routes>
      </BrowserRouter>
      <Container className='p-4 cnt'>
        <Header/>
      </Container>
      <Container>
        <div className="cont">
          {data.data?._embedded.foodList.map((e) => {return <Card name={e.name} kcal={e.kcal}/>})}
        </div>
        <p className="read-the-docs">
          Click on the Vite and React logos to learn more
        </p>
      </Container>
    </>
  )
}

export default App
