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

        if (response.headers.authorization) {
          const tokenSize = response.headers.authorization.length
          const user = {
            "username" : username,
            "token" : (response.headers.authorization).substr(7,tokenSize)
          };
          localStorage.setItem("user", JSON.stringify(user));
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