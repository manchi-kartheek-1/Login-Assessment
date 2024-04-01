import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const HelloUser = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigator = useNavigate();
  const handleLogout = () => {
    localStorage.removeItem('token');
    setIsLoggedIn(false);
    navigator('/userLogin');
};
  return (
    <div>Hello user</div>
  )
}

export default HelloUser