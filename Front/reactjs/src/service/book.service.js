import axios from "axios";
import authHeader from './auth-header';

const API_URL = "https://biblio-project.mohzaar.fr" //"https://biblio-project.mohzaar.fr";

class BookService {
  books() {
    return fetch(API_URL + "/books", { headers: authHeader() });
  }

  addBook(book) {
    return axios.post(API_URL + "/book", book, { headers: authHeader() });
  }
}

export default new BookService();