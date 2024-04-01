import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import UserLogin from './components/UserComponent/UserLoginPage';
import HelloWorld from './components/UserComponent/HelloWorld';

const router = createBrowserRouter([
  {
    path: "/userLogin",
    element: <UserLogin/>,
  },
  {
    path: "/",
    element: <UserLogin/>,
  },
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/helloWorld",
        element: <HelloWorld/>,
      }
    ],
  },
]);
const root = ReactDOM.createRoot(
  document.getElementById("root"));
root.render(<RouterProvider router={router} />);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
