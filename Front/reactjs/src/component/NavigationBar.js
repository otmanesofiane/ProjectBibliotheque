import React from 'react';
import * as react from "react";
import {Navbar,Nav} from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";


function handleLogout() {
  this.props.userHasAuthenticated(false);
}

class NavigationBar extends react.Component {
    
    render(){
        return (
            <Navbar collapseOnSelect bg="light" expand="md" className="mb-3">
              <LinkContainer to="/">
                <Navbar.Brand className="font-weight-bold text-muted">
                  Scratch
                </Navbar.Brand>
              </LinkContainer>
              <Navbar.Toggle />
            </Navbar>
        )
    }
}

export default  NavigationBar;
