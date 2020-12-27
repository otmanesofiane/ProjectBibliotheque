import React from 'react';
import {Container, Row, Col} from "react-bootstrap";

import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import './App.css';

import NavigationBar from "./component/NavigationBar";
import Welcome from "./component/Welcome";
import Footer from "./component/Footer";
import Livre from "./component/Livre";
import LivreList from "./component/LivreList";


function App() {

  const marginTop = {

    marginTop : "20px"
  };

  return (
      <Router>

        <NavigationBar></NavigationBar>
        <Container>
          <Row>
            <Col ls={12} style={marginTop}>
              <Switch>
                <Route path="/" exact component={Welcome} ></Route>
                <Route path="/addBook" exact component={Livre} ></Route>
                <Route path="/getBook" exact component={LivreList} ></Route>
              </Switch>
            </Col>
          </Row>
        </Container>
        <Footer></Footer>
      </Router>

  );
}

export default App;
