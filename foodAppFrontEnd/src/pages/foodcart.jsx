import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const FoodCart = () => {
  const [menus, setMenus] = useState([]);
  const [orderSummary, setOrderSummary] = useState({ totalItems: 0, totalCost: 0, products: [] });

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await axios.get("http://localhost:8083/getAllMenu");
        setMenus(result.data.data);
      } catch (error) {
        console.error("Error loading data:", error.message);
      }
    };

    fetchData();
  }, []);

  const handleAddToCart = (productName, productPrice) => {
    setOrderSummary((prevSummary) => ({
      totalItems: prevSummary.totalItems + 1,
      totalCost: prevSummary.totalCost + productPrice,
      products: [...prevSummary.products, `${prevSummary.totalItems + 1}) ${productName} = ₹${productPrice.toFixed(2)}`],
    }));
  };

  const handleRemoveFromCart = (index, product) => {
    const productPrice = parseFloat(product.split('= ₹')[1]);
    if (!isNaN(productPrice)) {
      setOrderSummary((prevSummary) => ({
        totalItems: prevSummary.totalItems - 1,
        totalCost: prevSummary.totalCost - productPrice,
        products: prevSummary.products.filter((_, i) => i !== index),
      }));
    }
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-4">
          <div className="order-summary mt-4 mb-4 p-3 bg-light rounded"  style={{ position: 'sticky', top: '20px', zIndex: 1 }}>
            <h4 className="mb-3">Order Summary</h4>
            <div className="products-list">
              {orderSummary.products.map((product, index) => (
                <div key={index} className={`d-flex justify-content-between mb-1 ${index % 2 === 0 ? 'text-success' : 'text-primary'}`}>
                  <p className="mb-0">{product}</p>
                  <button
                    className="btn btn-sm btn-danger"
                    onClick={() => handleRemoveFromCart(index, product)}
                    style={{
                      backgroundColor:'red',
                      color: 'white',
                      border: '1px solid #4caf50',
                      borderRadius: '10px',
                      cursor: 'pointer',
                      transition: 'background-color 0.3s', 
                      boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.3)',                                                                           
                    }}
                    onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
                    onMouseOut={(e) => e.target.style.backgroundColor = 'red'}
                  >
                    Remove
                  </button>
                </div>
              ))}
              <hr />
              <p className="mb-1 text-info">Total Items: {orderSummary.totalItems}</p>
              <p className="mb-1 text-danger">Total Cost: ₹{orderSummary.totalCost.toFixed(2)}</p>
            </div>
                                                            <div className="logout-container mt-4"style={{ position: 'sticky', top: 0, zIndex: 1 }}>
                                                                        <Link to="/"
                                                                          className="btn btn-primary"
                                                                          style={{
                                                                            marginTop: '10px',
                                                                            backgroundColor:'#2ff924',
                                                                            color: 'white',
                                                                            border: '1px solid #4caf50',
                                                                            padding: '10px 20px',
                                                                            borderRadius: '10px',
                                                                            boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)', 
                                                                            cursor: 'pointer',
                                                                            transition: 'background-color 0.3s',                                                                           
                                                                          }}
                                                                          onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
                                                                          onMouseOut={(e) => e.target.style.backgroundColor = '#2ff924'}
                                                                        >
                                                                          Logout
                                                                        </Link>
                                                                      </div>
            
          </div>
        </div>
        
        <div className="col-md-8">
          <h2 className="text-center mb-4">Food Cart</h2>

          {menus.map((menu) => (
            <div key={menu.menuId} className="mb-4">
              <h3>{menu.menuName}</h3>
              <table className="table table-bordered table-striped" style={{ borderRadius: '20px', boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',overflow: 'hidden' }}>
                <thead className="thead-dark">
                  <tr>
                    <th style={{textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)'}}>Product ID</th>
                    <th style={{textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)'}}>Product Name</th>
                    <th style={{textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)'}}>Product Price</th>
                    <th style={{textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)'}}>Product Description</th>
                    <th style={{textShadow: '2px 2px 5px rgba(0, 0, 0, 0.5)'}}>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {menu.productDtos.map((product, index) => (
                    <tr key={product.productId} className={index % 2 === 0 ? 'table-success' : 'table-info'}>
                      <td>{product.productId}</td>
                      <td>{product.productName}</td>
                      <td>₹{product.productPrice.toFixed(2)}</td>
                      <td>{product.productDescription}</td>
                      <td>
                        <button
                          className="btn btn-success"
                          style={{
                            //marginTop: '2px',
                            backgroundColor:'#ff7518',
                            color: 'white',
                            border: '1px solid #4caf50',                           
                            borderRadius: '10px',
                            boxShadow: '2px 2px 2px rgba(0, 0, 0, 0.4)', 
                            cursor: 'pointer',
                            transition: 'background-color 0.3s',
                          }}
                          onMouseOver={(e) => e.target.style.backgroundColor = '#ffbf00'}
                          onMouseOut={(e) => e.target.style.backgroundColor = '#ff7518'}
                          onClick={() => handleAddToCart(product.productName, product.productPrice)}
                        >
                          Add
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default FoodCart;


