import { useState } from 'react';
import '../public/styles/App.scss';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Card } from './components/cards/Card';
import { Header } from './components/header/Header';
import {useFoodData} from './hooks/useFoodData'

function App() {
  const data = useFoodData();

  return (
    <>
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
