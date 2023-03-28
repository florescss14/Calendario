import Header from "./Header";
import React, { useState } from "react";
import './Login.css' 

function Login(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const submit = (e) => {
      e.preventDefault(); 
      alert(`${username}, ${password}`); 
      //want to send username and password to backend here
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: username, password: password })
      };
    
      fetch('/api/login', requestOptions)
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(data => {
          // Handle successful login response from server
        })
        .catch(error => {
          // Handle
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
            placeholder="Username" 
            onChange={event => setUsername(event.target.value)}
            value={username}/>
            <input 
            type="password" 
            placeholder="Password" 
            onChange={event => setPassword(event.target.value)}
            value={password}/>
            <button>Login</button>
        </form>
    </div>
    );
}

export default Login;