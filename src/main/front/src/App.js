import logo from './logo.svg';
import './App.css';
import './index.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser } from "@fortawesome/free-solid-svg-icons";

import axios from "axios";
import React, {useState, useEffect} from "react";

function App() {
    const [msg, setMsg] = useState([]);
    useEffect(() => {
        fetch("/api/hello")
            .then((res) => {return res.json();})
            .then((data) => {setMsg(data);})
    }, []);
    return (
        <div className="App">
            <header className="App-header">
                <ul>
                    <FontAwesomeIcon icon={faUser}/>
                    {msg.map((content, idx) => <li key={`${idx} - ${content}`}>{content}</li>)}
                </ul>
            </header>
        </div>
    );
}

export default App;
