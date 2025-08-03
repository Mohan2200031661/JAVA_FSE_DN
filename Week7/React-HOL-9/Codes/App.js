import React from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';
import './App.css';

function App() {
  // Change this flag to toggle between views
  const flag = true;

  if (flag) {
    return (
        <div className="App">
          <ListofPlayers />
        </div>
    );
  } else {
    return (
        <div className="App">
          <IndianPlayers />
        </div>
    );
  }
}

export default App;