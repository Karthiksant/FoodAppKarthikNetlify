// SignupPage.jsx
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from '../navbar/navbar';
import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

const SignupPage = () => {
  // State variables for user details and error message
  const [userName, setUserName] = useState('');
  const [userAddress, setUserAddress] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userPassword, setUserPassword] = useState('');
  const [errorMsg, setErrorMsg] = useState('');

    // Access the navigate function
    const navigate = useNavigate();

  // Function to handle signup submission
  const handleSignup = async (e) => {
    e.preventDefault();

    try {
      // Make a POST request to create a new user
      const result = await axios.post("http://localhost:8083/saveUser", {
        userName,
        userAddress,
        userEmail,
        userPassword,
      });
      // Log success and navigate to the login page
      console.log('Signup successful');
      console.log('Response:', result.data);
      // Redirect to the login page after successful signup


      // You can replace this with your actual login page route
     // window.location.href = '/login';


      // Use the navigate function to navigate to the login page
      navigate('/login');
    } catch (error) {
      // Log and handle errors if signup fails
      console.error('Signup failed:', error.message);
      setErrorMsg('Signup failed. Please try again.');
    }
  };

  // JSX structure for the signup form
  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6" >
          <form onSubmit={handleSignup} style={{ border: '1px solid white', borderRadius: '25px', padding: '20px', boxShadow: '2px 2px 10px rgba(0, 0, 0, 0.4)',backgroundColor: '#676765' }}>
            <div className="mb-3">
              <div>
                <Navbar />
              </div>
              {/* Username input field */}
              <label htmlFor="userName" className="form-label" style={{ color: 'black', textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)', marginTop: '15px' }}>Username</label>
              <input
                type="text"
                className="form-control"
                id="userName"
                placeholder="Enter your username"
                value={userName}
                onChange={(e) => setUserName(e.target.value)}
                required
              />
            </div>
            <div className="mb-3">
              {/* User Address input field */}
              <label htmlFor="userAddress" className="form-label" style={{ color: 'black', textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)', marginTop: '15px' }}>User Address</label>
              <input
                type="text"
                className="form-control"
                id="userAddress"
                placeholder="Enter your address"
                value={userAddress}
                onChange={(e) => setUserAddress(e.target.value)}
                required
              />
            </div>
            <div className="mb-3">
              {/* Email input field */}
              <label htmlFor="userEmail" className="form-label" style={{ color: 'black', textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)', marginTop: '15px' }}>Email address</label>
              <input
                type="text"
                className="form-control"
                id="userEmail"
                placeholder="Enter your email"
                value={userEmail}
                onChange={(e) => setUserEmail(e.target.value)}
                required
              />
            </div>
            <div className="mb-3">
              {/* Password input field */}
              <label htmlFor="userPassword" className="form-label" style={{ color: 'black', textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)', marginTop: '15px' }}>Password</label>
              <input
                type="password"
                className="form-control"
                id="userPassword"
                placeholder="Enter your password"
                value={userPassword}
                onChange={(e) => setUserPassword(e.target.value)}
                required
              />
            </div>
            {/* Error message */}
            {errorMsg && <p style={{ color: 'red' }}>{errorMsg}</p>}
            {/* Submit button for the signup form */}
            <button
              type="submit"
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
              }}
              onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
              onMouseOut={(e) => e.target.style.backgroundColor = '#2ff924'}
            >
              Sign Up
            </button>
            {/* Link to navigate to the login page */}
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

export default SignupPage;


// import React from 'react'

// function SignUp() {
//   return (
//     <div>
//       <h1>im signup...!</h1>
//       <button></button>
//     </div>
//   )
// }

// export default SignUp
