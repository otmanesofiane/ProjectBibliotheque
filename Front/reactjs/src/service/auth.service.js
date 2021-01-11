import axios from "axios";

const API_URL = "http://localhost:8080"//"https://biblio-project.ncharfi.com";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "/login", {
        username,
        password
      })
      .then(response => {
          console.log(response)
        if (response.headers.authorization) {
          localStorage.setItem("token", JSON.stringify(response.headers.authorization).substr(8,response.headers.authorization.size));
        }
        return response.data;
      });
  }

  register(username, password) {
    return axios.post(API_URL + "/register", {
      username,
      password
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('token'));;
  }
}

export default new AuthService();