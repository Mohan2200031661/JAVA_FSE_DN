// src/TicketBookingController.js
import React, { Component } from 'react';
import UserPage from './UserPage';
import GuestPage from './GuestPage';

class TicketBookingController extends Component {
    constructor(props) {
        super(props);
        this.state = { isLoggedIn: false };
    }

    handleLoginClick = () => {
        this.setState({ isLoggedIn: true });
    };

    handleLogoutClick = () => {
        this.setState({ isLoggedIn: false });
    };

    render() {
        const isLoggedIn = this.state.isLoggedIn;
        let button;
        let page;

        if (isLoggedIn) {
            // If logged in, show UserPage and Logout button
            button = <button onClick={this.handleLogoutClick}>Logout</button>;
            page = <UserPage />;
        } else {
            // If not logged in, show GuestPage and Login button [cite: 40, 42]
            button = <button onClick={this.handleLoginClick}>Login</button>;
            page = <GuestPage />;
        }

        return (
            <div>
                {page}
                {button}
            </div>
        );
    }
}

export default TicketBookingController;