import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import { useHistory } from "react-router-dom";
import LoaderButton from "../LoaderButton/LoaderButton";
import { useAppContext } from "../../libs/contextLib";
import { useFormFields } from "../../libs/hooksLib";

import BookService from "../../service/book.service";

//import { onError } from "../libs/errorLib";
import "./BookForm.css";

export default function BookForm() {

const history = useHistory();
const [isLoading, setIsLoading] = useState(false);

  const [fields, handleFieldChange] = useFormFields({
    titre: "",
    desc: "",
    auteur: "",
    price: ""
  });

  function validateForm() {
    return (
      fields.titre.length > 0 &&
      fields.auteur.length > 0 &&
      fields.price.length > 0 
    );
  }

async function handleSubmit(event) {
    event.preventDefault();

    const book = {
        titre: fields.titre,
        desc: fields.desc,
        auteur: fields.auteur,
        price: fields.price
    };

    BookService.addBook(book)
        .then(
            response => {
              setIsLoading(true);
              history.push("/books");
            }, 
            error => {
                const resMessage =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();
                alert(resMessage)
            }
        );
  }

  function renderForm() {
    return (
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="titre" size="lg">
          <Form.Label>Titre</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            value={fields.titre}
            onChange={handleFieldChange}
          />
        </Form.Group>
        <Form.Group controlId="auteur" size="lg">
          <Form.Label>Auteur</Form.Label>
          <Form.Control
            type="auteur"
            value={fields.auteur}
            onChange={handleFieldChange}
          />
        </Form.Group>
        <Form.Group controlId="desc" size="lg">
          <Form.Label>Description</Form.Label>
          <Form.Control
            as="textarea" 
            rows={2}
            type="text"
            onChange={handleFieldChange}
            value={fields.desc}
          />
        </Form.Group>
        <Form.Group controlId="price" size="lg">
          <Form.Label>Prix (€)</Form.Label>
          <Form.Control
            type="number"
            onChange={handleFieldChange}
            value={fields.price}
          />
        </Form.Group> 
        <LoaderButton
          block
          size="lg"
          type="submit"
          variant="success"
          isLoading={isLoading}
          disabled={!validateForm()}
        >
          Ajouter
        </LoaderButton>
      </Form>
    );
  }

  return (
    <div className="BookForm">
      {renderForm()}
    </div>
  );
}