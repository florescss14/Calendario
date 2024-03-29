import { useEffect, useState, useContext } from 'react';
import Calendar from 'react-calendar'
import './App.css';
import DateEvent from './DateEvent';
import Header from './Header';
import './Header.css'
import AuthContext from "./context/AuthProvider";


function App() {
  const { auth } = useContext(AuthContext);
  const [date, setDate] = useState(new Date());
  useEffect(() => {
    console.log(date);
  }, [date]);
  return (

    <div className='all'> 
      <div className="Header"> 
        <Header />
      </div> 
      <div>
        {auth.username}
      </div>
      <div>
        <DateEvent/>
      </div>
      <div className="App center">
        <Calendar onChange={setDate} value={date}/>
      </div>
    </div>
  );
}

export default App;
