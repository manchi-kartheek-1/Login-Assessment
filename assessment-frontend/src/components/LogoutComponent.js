import React from 'react'
import { useNavigate } from 'react-router-dom';

export const LogoutComponent = () => {
    const navigate = useNavigate();
    const handleLogout = () => {
        navigate('/');
    };

    return (
        <button className='btn btn-danger' onClick={handleLogout}>Logout</button>
    )
}
export default LogoutComponent;