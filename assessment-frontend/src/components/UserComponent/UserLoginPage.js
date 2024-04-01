import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { userLogin, getOtp } from '../../services/employeeService';
import CustomDialog from './CustomDialog';

let user = null;
let logInResponse = null;
export { user, logInResponse };
function UserLoginPage() {
    localStorage.removeItem('token');
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');
    const [showDialog, setShowDialog] = useState(false);
    const [dialogMessage, setDialogMessage] = useState('');
    const [errors, setErrors] = useState({
        userId: '',
        password: ''
    });
    const handleDialogClose = () => {
        setShowDialog(false);
    };
    const navigate = useNavigate();
    const login = async (e) => {
        user = { userId, password };
        e.preventDefault();
        if (validateForm()) {
            try {
                const response = await userLogin(user);
                logInResponse = await userLogin(user);
                if (response.status === 200 || response.status === 201) {
                    localStorage.setItem('token', response.data.token);
                    navigate(`/helloWorld`);
                }
            } catch (error) {
                alert("Enter Valid Credentials");

            }
        }
    };
    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors };
        if (userId) {
            errorsCopy.userId = '';
        } else {
            errorsCopy.userId = "UserId is Required";
            valid = false;
        }

        if (password.trim()) {
            errorsCopy.password = '';
        } else {
            errorsCopy.password = "password is Required";
            valid = false;
        }

        setErrors(errorsCopy);
        return valid;
    }
    return (

        <div class="container">
            <CustomDialog show={showDialog} onClose={handleDialogClose} message={dialogMessage} />
            <h2>Login</h2>
            <form>
                {/* <label>User Id:</label> */}
                <div class="user-box">
                    <input
                        required
                        type='text'
                        placeholder='Enter User id'
                        value={userId}
                        className={`form-control ${errors.userId ? 'is-invalid' : ''}`}
                        onChange={(e) => setUserId(e.target.value)}
                    >
                    </input>
                    {errors.userId && <div className='invalid-feedback'>{errors.userId}</div>}
                </div>
                {/* <label>Password:</label> */}
                <div class="user-box">
                    <input
                        required
                        type='password'
                        placeholder='Enter Password'
                        value={password}
                        className={`form-control ${errors.password ? 'is-invalid' : ''}`}
                        onChange={(e) => setPassword(e.target.value)}
                    >
                    </input>
                    {errors.password && <div className='invalid-feedback'>{errors.password}</div>}
                </div>
                <div className='formButtons'>
                    <a onClick={login}>
                        Submit
                    </a>
                </div>
            </form>
        </div>

    );
}

export default UserLoginPage;

