import './App.css';
import './index.css'
import { RouterProvider} from "react-router-dom";
import root from './router/root';
    
    function App() {
   return (
    <RouterProvider router={root}></RouterProvider> //라우터 , root.js
);
}

export default App;
