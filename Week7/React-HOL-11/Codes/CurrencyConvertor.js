import React, { Component } from 'react';

class CurrencyConvertor extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rupees: 0,
            euros: 0
        };
    }

    handleRupeeChange = (event) => {
        this.setState({ rupees: event.target.value });
    };

    handleSubmit = () => { // [cite: 25]
        const euroValue = this.state.rupees / 90;
        this.setState({ euros: euroValue.toFixed(2) });
        alert('converting to euros ' + euroValue.toFixed(2)); // [cite: 24]

    };

    render() {
        return (
            <div>
                <h2>Currency Convertor</h2>
                <div>
                    <label>Indian Rupees (INR): </label>
                    <input type="number" value={this.state.rupees} onChange={this.handleRupeeChange} />
                </div>
                <button onClick={this.handleSubmit}>Convert</button> {/* [cite: 25] */}
                <h3>Euros (EUR): {this.state.euros}</h3>
            </div>
        );
    }
}

export default CurrencyConvertor;