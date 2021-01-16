import axios from "axios";
import authHeader from './auth-header';

const API_URL = "http://localhost:8080" //"https://biblio-project.mohzaar.fr";

class RentService {
  rents() {
    return axios.get(API_URL + "/rents", { headers: authHeader() });
  }

  addRent(idBook, username, rent) {
    return axios.post(API_URL + "/rents/"+username+"/"+idBook, rent, { headers: authHeader() });
  }
}

export default new RentService();