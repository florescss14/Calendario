import Header from "./Header";
import React, { useState, useContext } from "react";
import AuthContext from "./context/AuthProvider";
import './Login.css' 
import { useNavigate} from "react-router-dom"; 

function Login(){
    const { setAuth } = useContext(AuthContext);
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const submit = (e) => {
      e.preventDefault(); 
      //want to send username and password to backend here
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username: username, password: password })

      };
    
      fetch('http://localhost:8080/api/userlogin', requestOptions)
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then(data => {
          console.log(data);
          setAuth({username});
          setPassword("");
          setUsername("");
          navigate("/");
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
            placeholder="Username" 
            onChange={event => setUsername(event.target.value)}
            required
            value={username}/>
            <input 
            type="password" 
            placeholder="Password" 
            onChange={event => setPassword(event.target.value)}
            value={password}
            required/>
            <button>Login</button>
        </form>
    </div>
    );
}

export default Login;