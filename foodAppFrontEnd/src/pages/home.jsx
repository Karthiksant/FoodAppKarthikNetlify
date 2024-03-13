import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import swiggy_logo from '../images/swiggy_logo1.png'
import  profile_logo from '../images/profile_logo.jpg'
import  img1 from '../images/img1.jpg'
import  img2 from '../images/img2.jpg'
import  img3 from '../images/img3.jpg'
import  img4 from '../images/img4.jpg'
import  img5 from '../images/img5.jpg'
import  img6 from '../images/img6.jpg'
import '../pages/home.css'
import { Link } from 'react-router-dom';
const Home = () => {
  return (
    <div >
      {/* Main Content */}
      <div className="container mt-0"style={{ border: '1px solid #f5f5f5', borderRadius: '0px', padding: '15px', paddingLeft:'10%', boxShadow: '2px 2px 10px black',backgroundColor: '#676765' }}>
        <div className="row col-xl-12">
          <div className="row col-xl-12 ">

            {/* Navbar */}
       
              <div className="card-body mb-3" >
                <nav className="navbar navbar-light bg-light" style={{ borderRadius: '25px',}}>
                  <div className="container" style={{ borderRadius: '10px',}}>
                    {/* Food App Logo */}
                    <a className="navbar-brand" href="#">
                      <img
                        src={swiggy_logo}  // Replace with the path to your logo image
                        alt="..."
                        width="38"
                        height="34"
                        className="d-inline-block align-top"
                      />
                    </a>
                    
                    <Link
      to="/fddemo"
      type="submit"
      className="btn btn-primary"
      style={{
        margin: '0px',
        backgroundColor: '#1e90ff',
        color: 'white',
        border: '1px solid #4caf50',
        borderRadius: '20px',
        cursor: 'pointer',
        transition: 'background-color 0.1s',
        boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)',
        display: 'flex',
        alignItems: 'center', // Align items vertically in the center
        justifyContent: 'center', // Align content horizontally in the center
        textAlign: 'center', // Center text within the button
        animation: 'blinkAnimation 2s infinite', // Apply the blinking animation
      }}
    >
      <h5 style={{ color: '#ffffff', textShadow: '2px 2px 4px #3498db' }}>
        FOODieeApp..!
      </h5>
    </Link>
                   

                    {/* Navbar Content */}
                    <div id="navbarNav">
                          {/* Help and User Icons */}
                          <ul className="navbar-nav ml-auto d-flex flex-row">
                            <li className="nav-item">
                            <div className="div-img-container">
                                  <img
                                    src={profile_logo}  // Replace with the path to your logo image
                                    alt="..."
                                    width="30"
                                    height="33"
                                  />
                                </div>

                            </li>
                          </ul>
                        </div>
                  </div>
                </nav>
              </div>
  

            {/* New Card Body */}
            <div className="card mb-3">
              <div className="card-body" style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                {/* Content for the new card body */}
                <Link to="signup"  type="submit"
             className="btn btn-primary"
             style={{
              backgroundColor:'#1e90ff',
              color: 'white',
              textShadow: '1px 1px 1px #3498db',
              boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)', 
              border: '0px solid white',
              borderRadius: '10px',
              cursor: 'pointer',
              transition: 'background-color 0.2s', 
              marginLeft: '10px',                                                                          
            }}
            onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
            onMouseOut={(e) => e.target.style.backgroundColor = '#1e90ff'}
             >SignUp</Link>
              <Link to="login" type="submit"
             className="btn btn-primary"
             style={{
              backgroundColor:'#1e90ff',
              color: 'white' ,
              textShadow: '4px 4px 4px #3498db',
              boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)', 
              border: '0rem solid white',
              borderRadius: '10px',
              cursor: 'pointer',
              transition: 'background-color 0.2s', 
              marginLeft: '10px',                                                                          
            }}
            onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
            onMouseOut={(e) => e.target.style.backgroundColor ='#1e90ff '}
             >Login</Link>
              </div>
            </div>

            {/* Restaurant Cards */}
            
            <div className="card mb-4">
              <img src={img2} className="card-img-top" alt="Restaurant" />
              <div className="card-body">
                <h5 className="card-title">Santhosh Dhaba</h5>
                <p className="card-text">
                "Santhosh Dhaba Hotel offers delectable Indian cuisine with a blend of authentic flavors. Experience culinary excellence and exceptional service seamlessly on  online ."</p>
                <Link to="/fddemo" className="btn btn-primary">
                  View Menu
                </Link>
              </div>
            </div>
            <div className="card mb-4">
              <img src={img1} className="card-img-top" alt="Restaurant" />
              <div className="card-body">
                <h5 className="card-title">Udipi Hotel</h5>
                <p className="card-text">"Indulge in the diverse flavors of South Indian cuisine at Udipi Tiffin Centre. Enjoy a delightful array of traditional tiffin items online."</p>
                <Link to="/fddemo" className="btn btn-primary">
                  View Menu
                </Link>
              </div>
            </div>
            <div className="card mb-4">
              <img src={img5} className="card-img-top" alt="Restaurant" />
              <div className="card-body">
                <h5 className="card-title">Classic IceCreams</h5>
                <p className="card-text">"Savor the timeless taste of handcrafted ice cream at Classic Ice Cream. Treat yourself to premium flavors, crafted with perfection, available on our online hotel"</p>
                <Link to="/fddemo" className="btn btn-primary">
                  View Menu
                </Link>
              </div>
            </div>
            <div className="card mb-4">
              <img src={img3} className="card-img-top" alt="Restaurant" />
              <div className="card-body">
                <h5 className="card-title">KFC</h5>
                <p className="card-text">"Discover the legendary taste of fried chicken at KFC. Irresistible flavors, crispy perfection, and a variety of menu options available for online order."</p>
                <Link to="/fddemo" className="btn btn-primary">
                  View Menu
                </Link>
              </div>
            </div>
            <div className="card mb-4">
              <img src={img4} className="card-img-top" alt="Restaurant" />
              <div className="card-body">
                <h5 className="card-title">Domino's</h5>
                <p className="card-text">"Experience pizza perfection with Domino's. Delight in a world of flavors, quick delivery, and irresistible deals through our convenient online order."</p>
                <Link to="/fddemo" className="btn btn-primary">
                  View Menu
                </Link>
              </div>
            </div>
            <div className="card mb-4">
              <img src={img6} className="card-img-top" alt="Restaurant" />
              <div className="card-body">
                <h5 className="card-title">CoolDrinks</h5>
                <p className="card-text">"Quench your thirst at the Cooldrink Hotel. Explore a refreshing array of beverages, from classics to exotic flavors, conveniently available through  online"</p>
                <Link to="/fddemo" className="btn btn-primary">
                  View Menu
                </Link>
              </div>
            </div>
            

            {/* Add more restaurant cards as needed */}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
