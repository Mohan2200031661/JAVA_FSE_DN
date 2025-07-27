import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
    render() {
        const CartInfo = [
            { itemname: "Laptop", price: 80000 },
            { itemname: "TV", price: 120000 },
            { itemname: "Washing Machine", price: 50000 },
            { itemname: "Mobile", price: 30000 },
            { itemname: "Fridge", price: 70000 }
        ];

        return (
            <div className="mydiv" align={"center"} >
                <h1  style={{ color: "green" }}>Items Ordered :</h1>
                <table border="2">
                    <thead style={{ color: "green" }}>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody  style={{ color: "green" }}>
                    <Cart item={CartInfo} />
                    </tbody>
                </table>
            </div>
        );
    }
}

export default OnlineShopping;