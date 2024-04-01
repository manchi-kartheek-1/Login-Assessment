import axios from "axios";

const USER_BASE_URL="http://localhost:8080/api";

export const userLogin = (user)=>axios.post(USER_BASE_URL+'/userLogIn',user);
