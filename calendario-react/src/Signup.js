import Header from "./Header";
import React, { useState } from "react";
import './Login.css' 

function Signup(){
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [password2, setPassword2] = useState("");
    const submit = (e) => {
        e.preventDefault(); 
        if(password != password2){
            alert("Passwords do not match");
            return;
        }
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 
              firstName: firstName, 
              lastName: lastName, 
              username: username, 
              email: email,
              password: password })
    
          };

          fetch('http://localhost:8080/api/usersignup', requestOptions)
          .then(response => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            return response.json();
          })
          .then(data => {
            console.log(data);
          })
          .catch(error => {
            console.log("Some sort of error:" + error)
          });
      };

    return (
        <div className="all">
            <div className="Header">
                <Header/>
            </div>
            <form className="center" onSubmit={submit}>
                <input
                type="text"
                placeholder="First Name"
                onChange={event => setFirstName(event.target.value)}
                value={firstName}
                />
                <input
                type="text"
                placeholder="Last Name"
                onChange={event => setLastName(event.target.value)}
                value={lastName}
                />
                <input 
                type="text" 
                placeholder="Username" 
                onChange={event => setUsername(event.target.value)}
                value={username}
                />
                <input 
                type="email" 
                placeholder="email" 
                onChange={event => setEmail(event.target.value)}
                value={email}
                />
                <input 
                type="password" 
                placeholder="Password" 
                onChange={event => setPassword(event.target.value)}
                value={password}
                />
                <input 
                type="password" 
                placeholder="Password Again I Know..." 
                onChange={event => setPassword2(event.target.value)}
                value={password2}
                />
                <button>Signup</button>
            </form>
        </div>
        );
}

export default Signup;