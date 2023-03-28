import { Link } from "react-router-dom";


function Header(){
    if(!localStorage.getItem("user")){
        return(
            <div>
            <nav className="row">
                <Link className="home" to="/">Home</Link>
                <Link className="right user" to="/signup">Signup</Link>
                <Link className="user" to="/login">Login</Link>
            </nav>
        </div>
        //<><div className="home">Home</div><div className="login">Login</div></>
        );
    }else{
        return(
            <div>
            <nav className="row">
                <Link className="home" to="/">Home</Link>
                
                {/* Logout link should be made here */}
            </nav>
        </div>
        //<><div className="home">Home</div><div className="login">Login</div></>
        );
    }

}

export default Header;