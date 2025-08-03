import React from 'react';
import './App.css';
import Counter from './Counter';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
      <div className="App">
        <header className="App-header">
          <h1>React Event Handling Examples</h1>
          <Counter />
          <hr />
          <CurrencyConvertor />
        </header>
      </div>
  );
}

export default App;