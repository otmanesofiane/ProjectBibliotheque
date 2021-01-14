import axios from "axios";
import authHeader from './auth-header';

const API_URL = "https://biblio-project.mohzaar.fr" //"https://biblio-project.mohzaar.fr";

class RentService {
  rents() {
    return axios.get(API_URL + "/rents", { headers: authHeader() });
  }

  addRent(idBook, username, rent) {
    return axios.post(API_URL + "/rents/"+username+"/"+idBook, rent, { headers: authHeader() });
  }
}

export default new RentService();