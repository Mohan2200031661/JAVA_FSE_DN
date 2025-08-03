// src/UserPage.js
import React from 'react';

function UserPage() {
    return (
        <div>
            <h2>Welcome back</h2>
            <p>Here are the latest flight details:</p>
            <ul>
                <li>Flight to New York - <b><button>Book Now</button></b></li>
                <li>Flight to London - <b><button>Book Now</button></b></li>
            </ul>
        </div>
    );
}

export default UserPage;