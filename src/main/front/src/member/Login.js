import React, { useState } from 'react';
import axios from 'axios';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!username.trim()) {
      alert('아이디를 입력해주세요');
      return;
    }

    if (!password.trim()) {
      alert('비밀번호를 입력해주세요');
      return;
    }

    try {
      const response = await axios.post('http://localhost:8090/api/v1/members/login', {
        username,
        password
    
      });
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input 
        type="text" 
        value={username} 
        onChange={(e) => setUsername(e.target.value)} 
        placeholder="Username" 
      />
      <input 
        type="password" 
        value={password} 
        onChange={(e) => setPassword(e.target.value)} 
        placeholder="Password" 
      />
      <button className="btn btn-primary" type="submit">Submit</button>
    </form>
  );
};
export default Login;