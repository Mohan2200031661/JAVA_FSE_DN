import React from "react";
import '../Stylesheets/mystyle.css'

const percentToDecimal = (decimal) => {
    return (decimal).toFixed(2) + '%';
};

const calcScore = (total, goal) => {
    return percentToDecimal(total / goal);
};

export const CalculateScore = ({ name, school, total, goal }) => (
    <div className="student-card">
        <h1 className="student-title">Student Details</h1>
        <div className="Name">
            <b>Name: </b>
            <span>{name}</span>
        </div>
        <div className="School">
            <b>School: </b>
            <span>{school}</span>
        </div>
        <div className="Total">
            <b>Total: </b>
            <span>{total}</span>
            <span> Marks</span>
        </div>
        <div className="Score">
            <b>Score: </b>
            <span>
                {calcScore(total, goal)}
            </span>
        </div>
    </div>
);