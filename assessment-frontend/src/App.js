import './App.css';
import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import { Box } from '@mui/material';

function App() {
  let token = localStorage.getItem('token');
  const getLoginUrl = (loginType) => {
    const base ='/userLogin';
    return `${base}?from=${btoa(window.location.pathname + window.location.search)}`;
  };
  return (
    <>

      <React.Fragment>
        {token ? (
          <div id="detail">
            <>
              <div>
                <Box>
                  <Outlet />
                </Box>
              </div>
            </>
          </div>
        ) : (
          <Navigate to={getLoginUrl()} />
        )}
      </React.Fragment>

    </>

  );

}

export default App;
