import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

// Sample office data
const officeList = [
  {
    id: 1,
    name: 'Skyview Workspace',
    rent: 55000,
    address: '123 Main Street, Hyderabad',
    image: 'https://via.placeholder.com/300x200?text=Skyview+Workspace'
  },
  {
    id: 2,
    name: 'TechHub Offices',
    rent: 75000,
    address: '456 Tech Park, Bangalore',
    image: 'https://via.placeholder.com/300x200?text=TechHub+Offices'
  },
  {
    id: 3,
    name: 'Innovate Towers',
    rent: 60000,
    address: '789 Innovation Drive, Chennai',
    image: 'https://via.placeholder.com/300x200?text=Innovate+Towers'
  }
];

const App = () => {
  return (
      <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
        <h1>Office Space Rental App</h1>
        {officeList.map((office) => (
            <div key={office.id} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '15px', borderRadius: '8px', maxWidth: '400px' }}>
              <img src={office.image} alt={office.name} style={{ width: '100%', borderRadius: '5px' }} />
              <h2>{office.name}</h2>
              <p style={{ color: office.rent < 60000 ? 'red' : office.rent > 60000 ? 'green' : 'black', fontWeight: 'bold' }}>Rent: ₹{office.rent}</p>
              <p>Address: {office.address}</p>
            </div>
        ))}
      </div>
  );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
