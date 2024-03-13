// LoginPage.jsx
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from '../navbar/navbar';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

const LoginPage = () => {
  // State variables for email, password, user data, error message, and navigate
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loadSQLData, setLoadSQLData] = useState([]);
  const [errorMsg, setErrorMsg] = useState('');
  const navigate = useNavigate(); // Use navigate instead of history

  // Function to load user data from the server
  const loadItems = async () => {
    try {
      // Make a GET request to fetch user data
      const result = await axios.get("http://localhost:8083/getAllUsers");
      
      // Log success and update state with fetched data
      console.log("Data loaded successfully");
      setLoadSQLData(result.data.data);
    } catch (error) {
      // Log and handle errors if the data loading fails
      console.error("Error loading data:", error.message);
    }
  };

  // Load user data when the component mounts
  useEffect(() => {
    loadItems();
  }, []);

  // Function to handle login submission
  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      // Ensure data is loaded before checking credentials
      await loadItems();

      // Check if the entered email and password match any user
      const isValidUser = loadSQLData.some((item) => item.userEmail === email && item.userPassword === password);

      if (isValidUser) {
        // Navigate to the next page (replace this with your actual page)
        navigate('/fdcart');
        console.log('Login successful');
        console.log('Email:', email);
        console.log('Password:', password);

        // Clear form fields after successful login
        setEmail('');
        setPassword('');
      } else {
        // Display an error message
        setErrorMsg('Invalid email or password. Please try again.');
        console.log('Login failed');
      }
    } catch (error) {
      // Log and handle authentication errors
      console.error('Authentication failed', error.message);
    }
  };

  // JSX structure for the login form
  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <form onSubmit={handleLogin} style={{ border: '1px solid white', borderRadius: '25px', padding: '20px', boxShadow: '2px 2px 10px rgba(0, 0, 0, 0.4)',backgroundColor: '#676765' }}>
            <div className="mb-3">
              <div>
                <Navbar />
              </div>
              {/* Email input field */}
              <label htmlFor="email" className="form-label" style={{ color: 'black', textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)', marginTop: '15px' }}>Email address</label>
              <input
                type="text"
                className="form-control"
                id="email"
                placeholder="Enter your email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                
              />
            </div>
            <div className="mb-3">
              {/* Password input field */}
              <label htmlFor="password" className="form-label" style={{ color: 'black', textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)', marginTop: '15px' }}>Password</label>
              <input
                type="password"
                className="form-control"
                id="password"
                placeholder="Enter your password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
               
              />
            </div>
            {/* Error message */}
            {errorMsg && <p style={{ color: 'red' }}>{errorMsg}</p>}
            
              <Link to="/fdcart" type="submit"
             className="btn btn-primary"
             style={{
              marginTop: '10px',
              backgroundColor:'#2ff924',
              color: 'white',
              border: '1px solid #4caf50',
              borderRadius: '10px',
              boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)',
              cursor: 'pointer',
              transition: 'background-color 0.3s', 
              marginLeft: '10px',                                                                          
            }}
            onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
            onMouseOut={(e) => e.target.style.backgroundColor = '#2ff924'}
             >Login</Link>
             <Link
              to="/fddemo"
              className="btn btn-primary"
             
              style={{
                marginTop: '10px',
                backgroundColor: '#2ff924',
                color: 'white',
                border: '1px solid #4caf50',
                borderRadius: '10px',
                boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)',
                cursor: 'pointer',
                transition: 'background-color 0.3s',
                marginLeft: '10px',
              }}
              onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
              onMouseOut={(e) => e.target.style.backgroundColor = '#2ff924'}
            >
              Menu
            </Link>
             <Link
              to="/"
              className="btn btn-primary"
              style={{
                marginTop: '10px',
                backgroundColor: '#2ff924',
                color: 'white',
                border: '1px solid #4caf50',
                borderRadius: '10px',
                boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)',
                cursor: 'pointer',
                transition: 'background-color 0.3s',
                marginLeft: '10px',
              }}
              onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
              onMouseOut={(e) => e.target.style.backgroundColor = '#2ff924'}
            >
              Back
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;



