import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './navbar.css'
const Navbar = ({ backgroundColor, textColor }) => {


  return (
   <nav className="navbar navbar-expand-lg navbar-light" 
   style={{
     color: 'gold',
    backgroundColor: backgroundColor || '#2bd022',
   color: textColor || 'black', 
    textShadow: '2px 2px 4px rgba(0, 0, 0, 0.5)',
    borderRadius: '20px',
  
    }} >

   <div className="container" >
   <h2 className="text-center mb-0" style={{ color: 'white', textShadow: '2px 2px 4px rgba(0, 0, 0, 0.6)' }}>FOODieeApp..!</h2>

     <h3 className="text-center mb-0"style={{  color: 'gold',textShadow: '2px 2px 4px rgba(0, 0, 0, 0.5)' }}></h3>
     <button className="btn" style={{ backgroundColor: 'grey'  }}> 
     <span className="navbar-toggler-icon"></span>
     </button>
   </div>
 </nav>
  );
};

export default Navbar;
