import * as react from "react";
import {Card, Table} from "react-bootstrap";
import axios from "axios";

class  BooksList extends react.Component {

    constructor(props) {
        super(props);
        this.state = {
            books :[]
        };
    }
    componentDidMount() {
        axios.get("http://localhost:8080/livres",{
            headers: {"Access-Control-Allow-Origin": "*"}

        })
            .then(response => response.data)
            .then((data) =>{
                this.setState({books:data});
            })



    }
    render() {
        return (
            <Card>

                <Card.Header>Liste des livres </Card.Header>
                <Card.Body>
                    <Table bordered hover striped>

                        <thead>
                        <tr>
                            <th>Identifiant</th>
                            <th>Titre</th>
                            <th>Prix</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.books.length === 0 ?
                            <tr>
                                <td className={"text-center"} colSpan="6">Aucun livre de disponible</td>
                            </tr> :
                            this.state.books.map((book) =>(
                                <tr key = {book.id}>
                                    <td>{book.id}</td>
                                    <td>{book.titre}</td>
                                    <td>{book.price}</td>
                                </tr>
                            ))

                        }
                        </tbody>
                    </Table>

                </Card.Body>

            </Card>

        );
    }



}

export default BooksList;