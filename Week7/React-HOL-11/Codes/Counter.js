import React, { Component } from 'react';

class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({ count: this.state.count + 1 });
    };

    sayHello = () => {
        alert('Hello Member');
    };

    handleIncrease = () => {
        this.increment(); // [cite: 20]
        this.sayHello(); // [cite: 21]
    };

    decrement = () => {
        this.setState({ count: this.state.count - 1 });
    };

    sayWelcome = (message) => {
        alert(message);
    };

    handlePress = (event) => {
        console.log(event);
        alert('I was clicked'); // [cite: 23]
    };

    render() {
        return (
            <div>
                <h2>Counter Value: {this.state.count}</h2>
                <button onClick={this.handleIncrease}>Increase</button> {/* [cite: 19] */}

                <button onClick={this.decrement}>Decrement</button> {/* [cite: 18] */}

                <button onClick={() => this.sayWelcome('Welcome')}>Say Welcome</button> {/* [cite: 22] */}

                <button onClick={this.handlePress}>OnPress</button> {/* [cite: 23] */}
            </div>
        );
    }
}

export default Counter;