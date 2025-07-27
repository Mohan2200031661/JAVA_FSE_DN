import React, { Component } from 'react';

class CountPeople extends Component {
    constructor(props) {
        super(props);
        this.state = {
            entrycount: 0,
            exitcount: 0,
        };
    }

    updateEntry = () => {
        this.setState((prevState) => ({
            entrycount: prevState.entrycount + 1,
        }));
    };

    updateExit = () => {
        this.setState((prevState) => ({
            exitcount: prevState.exitcount + 1,
        }));
    };

    render() {
        return (
            <div style={{ textAlign: 'center', marginTop: '50px' }}>
                <button onClick={this.updateEntry} style={{ marginRight: '20px' }}>Login</button>
                <span>{this.state.entrycount} People Entered!!!</span>

                <button onClick={this.updateExit} style={{ marginLeft: '50px', marginRight: '20px' }}>Exit</button>
                <span>{this.state.exitcount} People Left!!!</span>
            </div>
        );
    }
}

export default CountPeople;