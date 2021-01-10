import axios from "axios";
import authHeader from './auth-header';

const API_URL = "http://localhost:8080" //"https://biblio-project.ncharfi.com";

class BookService {
  books() {
    return fetch(API_URL + "/books", { headers: authHeader() });
  }

  addBook(book) {
    return axios.post(API_URL + "/book", book, { headers: authHeader() });
  }
}

export default new BookService();