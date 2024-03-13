// OrderConfirmed.jsx
import React from 'react';
import { Link } from 'react-router-dom';

const OrderConfirmed = () => {
  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div
            className="text-center p-4 rounded"
            style={{
              backgroundColor: '#1e90ff',
              color: 'white',
              boxShadow: '0 0 15px rgba(0, 0, 0, 0.3)',
              borderRadius: '15px',
              padding: '20px',
              transition: 'background-color 0.3s, transform 0.3s',
              cursor: 'pointer',
              transform: 'scale(1)',
            }}
          >
            <h2 style={{ fontSize: '2rem', marginBottom: '10px' }}>Order Confirmed!</h2>
            <h2 style={{ fontSize: '2rem', marginBottom: '10px' }}>KarthikSant...!</h2>
            <p style={{ fontSize: '1.2rem', marginBottom: '15px' }}>Your order has been successfully placed.</p>
            {/* You can add more details or order summary information here */}
            <p style={{ fontSize: '1.2rem', marginBottom: '15px' }}>Thank you for choosing our services.</p>
            <hr style={{ borderTop: '1px solid white', marginBottom: '15px' }} />
            <p style={{ fontSize: '1.1rem', marginBottom: '15px' }}>
              <strong>Order Number: 7985287</strong> {/* Display the order number dynamically */}
            </p>
            <p style={{ fontSize: '1.2rem', marginBottom: '15px' }}>We hope you enjoy your meal!</p>

            <Link
              to="/"
              className="btn btn-primary mt-3"
              style={{
                backgroundColor: '#ec9006',
                color: 'white',
                border: '1px solid #4caf50',
                borderRadius: '10px',
                padding: '10px 20px',
                boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)',
                transition: 'background-color 0.3s',
                marginRight: '10px',
              }}
            >
              Home
            </Link>
            <Link
              to="/fddemo"
              className="btn btn-primary mt-3"
              style={{
                backgroundColor:'#ec9006',
                color: 'white',
                border: '1px solid #4caf50',
                borderRadius: '10px',
                padding: '10px 20px',
                boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)',
                transition: 'background-color 0.3s',
                marginRight: '10px',
              }}
            >
            Menu
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default OrderConfirmed;


// // OrderConfirmed.jsx
// import React from 'react';

// const OrderConfirmed = () => {
//   return (
//     <div className="container mt-5">
//       <div className="row justify-content-center">
//         <div className="col-md-6">
//           <div className="text-center">
//             <h2>Order Confirmed!</h2>
//             <p>Your order has been successfully placed.</p>
//             <p>Thank you for choosing our services.</p>
//             {/* You can add more details or order summary information here */}
//             <p>We hope you enjoy your meal!</p>
//             <hr />
//             <p>
//               <strong>Order Number:</strong> {/* Display the order number dynamically */}
//             </p>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default OrderConfirmed;
