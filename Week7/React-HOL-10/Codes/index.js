import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

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
    // Main container styles for a modern look
    const appStyles = {
        backgroundColor: '#f4f7f9',
        padding: '40px 20px',
        fontFamily: 'system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center'
    };

    // Card styles using shadows instead of borders
    const cardStyles = {
        backgroundColor: '#ffffff',
        boxShadow: '0 6px 18px rgba(0,0,0,0.07)',
        borderRadius: '12px',
        marginBottom: '25px',
        maxWidth: '400px',
        overflow: 'hidden' // Ensures the image corners are clipped
    };

    const imageStyles = {
        width: '100%',
        display: 'block' // Removes extra space below the image
    };

    // Wrapper for the text content inside the card
    const contentStyles = {
        padding: '15px 25px 25px 25px'
    };

    const titleStyles = {
        margin: '0 0 10px 0',
        fontSize: '1.4rem',
        color: '#2c3e50'
    };

    const addressStyles = {
        margin: '0',
        color: '#7f8c8d',
        fontSize: '0.95rem'
    };

    return (
        <div style={appStyles}>
            <h1 style={{ color: '#2c3e50', marginBottom: '40px' }}>Office Space Rental App</h1>
            {officeList.map((office) => {
                // Rent styles with corrected and more appealing colors
                const rentStyles = {
                    color: office.rent < 60000 ? '#27ae60' : office.rent > 60000 ? '#e74c3c' : '#34495e',
                    fontWeight: 'bold',
                    fontSize: '1.2rem',
                    margin: '0 0 15px 0'
                };

                return (
                    <div key={office.id} style={cardStyles}>
                        <img src={office.image} alt={office.name} style={imageStyles} />
                        <div style={contentStyles}>
                            <h2 style={titleStyles}>{office.name}</h2>
                            <p style={rentStyles}>Rent: ₹{office.rent.toLocaleString('en-IN')}</p>
                            <p style={addressStyles}>Address: {office.address}</p>
                        </div>
                    </div>
                );
            })}
        </div>
    );
};

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);