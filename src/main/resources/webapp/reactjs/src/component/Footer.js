import {Col, Container, Navbar} from "react-bootstrap";
import React from "react";
import * as react from "react";



class  Footer extends react.Component {


    render(){
        return (
            <Navbar fixed={"bottom"}  bg="dark" variant="dark">
                <Container>
                    <Col ls={12} className="text-center text-white">

                        <div>Tous droits réservés à Otmane Soufiane & Benzaid Adel</div>

                    </Col>
                </Container>
            </Navbar>

        );
    }
}

export default Footer;