import React from 'react';

// The OfficeCard component is a reusable component that receives
// office data as a prop and displays it.
const OfficeCard = ({ office }) => {
    // Helper function to determine the color based on rent
    const getRentColor = (rent) => {
        // Return a Tailwind CSS class string
        return rent <= 60000 ? 'text-red-500' : 'text-green-500';
    };

    return (
        <div className="p-6 bg-gray-50 rounded-xl shadow-lg transform transition-transform duration-300 hover:scale-105">
            {/* Image of the office space */}
            <div className="mb-4">
                <img
                    src={office.imageUrl}
                    alt={`${office.name} office space`}
                    className="rounded-lg w-full h-48 object-cover"
                />
            </div>

            {/* Office details */}
            <div className="space-y-2">
                <h2 className="text-2xl font-bold text-gray-700">
                    Name: {office.name}
                </h2>
                <h3 className="text-lg font-medium">
                    {/* Apply conditional styling to the rent */}
                    Rent: <span className={getRentColor(office.rent)}>Rs. {office.rent}</span>
                </h3>
                <h3 className="text-lg text-gray-600">
                    Address: {office.address}
                </h3>
            </div>
        </div>
    );
};

// The main App component holds the data and renders the list of OfficeCard components.
const App = () => {
    // Define an array of office space objects with details
    const offices = [
        {
            name: 'DBS',
            rent: 50000,
            address: 'Chennai',
            imageUrl: 'https://placehold.co/400x300/E0F7FA/212121?text=DBS+Office',
        },
        {
            name: 'WeWork',
            rent: 75000,
            address: 'Bangalore',
            imageUrl: 'https://placehold.co/400x300/E8F5E9/212121?text=WeWork+Office',
        },
        {
            name: 'Regus',
            rent: 45000,
            address: 'Mumbai',
            imageUrl: 'https://placehold.co/400x300/FFF3E0/212121?text=Regus+Office',
        },
        {
            name: 'Awfis',
            rent: 62000,
            address: 'Delhi',
            imageUrl: 'https://placehold.co/400x300/FBE9E7/212121?text=Awfis+Office',
        },
    ];

    return (
        <div className="min-h-screen bg-gray-100 p-8 font-sans antialiased text-gray-900">
            <div className="container mx-auto p-6 bg-white shadow-xl rounded-2xl">
                {/* Main heading of the page */}
                <h1 className="text-4xl font-extrabold text-center mb-10 text-gray-800">
                    Office Space, at Affordable Range
                </h1>

                {/* Display the list of office spaces */}
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                    {/* Map through the offices array and render an OfficeCard for each one */}
                    {offices.map((office, index) => (
                        // Pass the office object as a prop to the OfficeCard component
                        <OfficeCard key={index} office={office} />
                    ))}
                </div>
            </div>
        </div>
    );
};

export default App;
