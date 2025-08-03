// src/App.js
import React from 'react';
import './App.css';
import TicketBookingController from './TicketBookingController';

function App() {
  return (
      <div className="App">
        <header className="App-header">
          <h1>Flight Ticket Booking</h1>
          <TicketBookingController />
        </header>
      </div>
  );
}

export default App;