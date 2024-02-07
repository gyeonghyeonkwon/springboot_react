import './App.css';
import { Routes, Route} from "react-router-dom";
import Main from './pages/Main';
import Login from './member/Login';

    function App() {
   return (
   <Routes>
        <Route path='/' element={<Main/>}/>
        <Route path='/member/login' element={<Login/>}/>
    </Routes>
)
}

export default App;
