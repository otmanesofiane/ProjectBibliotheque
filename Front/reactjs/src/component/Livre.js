import * as react from "react";
import {Card,Form,Button} from "react-bootstrap";

class Livre extends react.Component {

    constructor(props) {
        super(props);
        this.state = {titre :"" , prix:""};
        this.bookChange = this.bookChange.bind(this);
        this.submitBook = this.submitBook.bind(this);
    }

    submitBook (event) {
        alert(this.state.titre);
        event.preventDefault();
    }
    bookChange(event){
        this.setState({
            [event.target.name]:event.target.name
        })
    }
    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Ajout de livre </Card.Header>
                <Card.Body>
                    <Form  onSubmit={this.submitBook} id={"BookIdForm"}>
                        <Form.Group controlId="formBasicTitre">
                            <Form.Label>Titre</Form.Label>
                            <Form.Control required
                                          name="titre"
                                          type="text"
                                          placeholder="Entrez le titre du livre"
                                          value={this.state.titre}
                                          onChange={this.bookChange}
                            />
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Card.Body>
            </Card>
        );
    }



}

export default Livre;