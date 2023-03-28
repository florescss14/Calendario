import Header from "./Header";
import React, { useState } from "react";
import './Login.css' 

function Signup(){
    return (
        <div className="all">
            <div className="Header">
                <Header/>
            </div>
            <form className="center" >
                <input
                type="text"
                placeholder="First Name"
                />
                <input
                type="text"
                placeholder="Last Name"
                />
                <input 
                type="text" 
                placeholder="Username" 
                />
                <input 
                type="password" 
                placeholder="Password" 
                />
                <input 
                type="password" 
                placeholder="Password Again I Know..." 
                />
                <button>Signup</button>
            </form>
        </div>
        );
}

export default Signup;