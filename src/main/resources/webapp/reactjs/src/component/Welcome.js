import {Jumbotron} from "react-bootstrap";
import React from "react";
import * as react from "react";



class  Welcome extends react.Component {


    render(){
        return (

            <Jumbotron className="bg-dark - text-white text-center">
                <h1>Bonjour !</h1>
                <p>
                    Bienvenue dans notre bibliotheque en ligne
                </p>

            </Jumbotron>

        );
    }
}

export default Welcome;