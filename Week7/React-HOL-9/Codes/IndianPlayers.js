import React from 'react';

function OddPlayers({ players }) {
    const [, first, , third, , fifth] = players;
    return (
        <div>
            <h2>Odd Players</h2>
            <ul>
                <li>First: {first}</li>
                <li>Third: {third}</li>
                <li>Fifth: {fifth}</li>
            </ul>
        </div>
    );
}

function EvenPlayers({ players }) {
    const [second, , fourth, , sixth] = players;
    return (
        <div>
            <h2>Even Players</h2>
            <ul>
                <li>Second: {second}</li>
                <li>Fourth: {fourth}</li>
                <li>Sixth: {sixth}</li>
            </ul>
        </div>
    );
}

function IndianPlayers() {
    const IndianTeam = ['Sachin 1', 'Dhoni 2', 'Virat 3', 'Rohit 4', 'Yuvraj 5', 'Raina 6'];

    const T20Players = ['First Player', 'Second Player', 'Third Player'];
    const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

    // Merging two arrays using the spread operator [cite: 27]
    const IndianPlayersMerged = [...T20Players, ...RanjiTrophyPlayers];

    return (
        <div>
            <OddPlayers players={IndianTeam} />
            <hr />
            <EvenPlayers players={IndianTeam} />
            <hr />
            <h2>List of Indian Players Merged:</h2>
            <ul>
                {IndianPlayersMerged.map((player, index) => (
                    <li key={index}>Mr. {player}</li>
                ))}
            </ul>
        </div>
    );
}

export default IndianPlayers;