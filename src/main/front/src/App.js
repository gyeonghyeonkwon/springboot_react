import './App.css';
import './index.css'
import { Routes, Route} from "react-router-dom";
import Main from './pages/Main';
import PostList from './post/list/PostList';
import Login from './member/Login';
import Write from './post/create/Write';
    
    function App() {
   return (
   <Routes>
        <Route path='/' element={<Main/>}/>
        <Route path='/member/login' element={<Login/>}/>
        <Route path='/post/list' element={<PostList/>}/>
        <Route path='/post/create' element={<Write/>}/>

    </Routes>
)
}

export default App;
