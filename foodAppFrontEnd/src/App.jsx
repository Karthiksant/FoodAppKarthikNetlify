// App.jsx
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Home from './pages/home';
import FoodCart from './pages/foodcart';
import SignUp from './pages/signup';
import LoginPage from './pages/login';
import FoodCartDemo from './pages/foodcartdemo';
import OrderConfirmed from './pages/orderconfirmed';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path='/' element={<Home />} />
          <Route exact path='/fdcart' element={<FoodCart />} />
          <Route exact path='/signup' element={<SignUp />} />
          <Route exact path='/login' element={<LoginPage />} />
          <Route exact path='/orderconfirmed' element={<OrderConfirmed />} />
          <Route exact path='/fddemo' element={<FoodCartDemo />} />         
        </Routes>
      </Router>
    </div>
  );
}

export default App;