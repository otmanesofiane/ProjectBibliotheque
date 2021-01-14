import React, { useState, useEffect } from 'react';
import {BrowserRouter as Router} from "react-router-dom";
import { AppContext } from "./libs/contextLib";

import {Navbar,Nav} from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";

import Footer from './component/Footer/Footer'

import './App.css';

import Routes from "./Routes"

function App() {

  const [isAuthenticated, userHasAuthenticated] = useState(false);

  useEffect(() => {
    onLoad();
  }, []);
  
  async function onLoad() {
      if(localStorage.getItem('user')){
        userHasAuthenticated(true);
      }
  }

  function handleLogout() {
    localStorage.removeItem('user');
    userHasAuthenticated(false);
  }

  return (
      <div className="App container py-3">
      <Router>
      <Navbar collapseOnSelect bg="light" expand="md" className="mb-3">
              <LinkContainer to="/">
                <Navbar.Brand className="font-weight-bold text-muted">
                  Bibliothèque
                </Navbar.Brand>
              </LinkContainer>
              <LinkContainer to="/books">
                <Navbar.Collapse>
                    <LinkContainer to="/books">
                      <Nav.Link>Consulter les livres</Nav.Link>
                    </LinkContainer>
                    <LinkContainer to="/booksform">
                      <Nav.Link>Ajouter un livre</Nav.Link>
                    </LinkContainer>
                </Navbar.Collapse>
              </LinkContainer>
              <Navbar.Toggle />
              <Navbar.Collapse className="justify-content-end">
                <Nav activeKey={window.location.pathname}>
                {isAuthenticated ? (
                  <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
                ) : (
                  <>
                    <LinkContainer to="/signup">
                      <Nav.Link>Inscription</Nav.Link>
                    </LinkContainer>
                    <LinkContainer to="/login">
                      <Nav.Link>Connexion</Nav.Link>
                    </LinkContainer>
                  </>
                )}
                </Nav>
              </Navbar.Collapse>
            </Navbar>
        <AppContext.Provider value={{ isAuthenticated, userHasAuthenticated }}>
          <Routes />
        </AppContext.Provider>
      </Router>
      <Footer></Footer>
      </div>
    );
}

export default App;
