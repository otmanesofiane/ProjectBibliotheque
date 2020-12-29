import React from 'react';
import * as react from "react";
import {Navbar,Nav} from "react-bootstrap";
import {Link} from "react-router-dom";


class NavigationBar extends react.Component {


    render(){
        return (
            <Navbar  bg="dark" variant="dark">
                <Link to={""}  className= "navbar-brand">
                    <Navbar.Brand href="/">Bibliotheque</Navbar.Brand>
                </Link>
                <Nav className="mr-auto">
                    <Link to={"/getBook"} className="nav-link">Consulter les livres </Link>
                    <Link to={"/addBook"} className="nav-link">Ajouter des livres</Link>
                </Nav>

            </Navbar>


        )
    }
}

export default  NavigationBar;
