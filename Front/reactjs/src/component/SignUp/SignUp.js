import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import { useHistory } from "react-router-dom";
import LoaderButton from "../LoaderButton/LoaderButton";
import { useAppContext } from "../../libs/contextLib";
import { useFormFields } from "../../libs/hooksLib";

import AuthService from "../../service/auth.service";

//import { onError } from "../libs/errorLib";
import "./SignUp.css";

export default function Signup() {
  const [fields, handleFieldChange] = useFormFields({
    username: "",
    password: "",
    confirmPassword: "",
  });
  const history = useHistory();
  const [isLoading, setIsLoading] = useState(false);

  function validateForm() {
    return (
      fields.username.length > 0 &&
      fields.password.length > 0 &&
      fields.password === fields.confirmPassword
    );
  }

  async function handleSubmit(event) {
    event.preventDefault();

    const user = {
      username: fields.username,
      password: fields.password
    };

    AuthService.register(
      user.username,
      user.password
    ).then(
      response => {
        console.log(response)
        setIsLoading(true);
        history.push("/");
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
        <Form.Group controlId="username" size="lg">
          <Form.Label>username</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            value={fields.username}
            onChange={handleFieldChange}
          />
        </Form.Group>
        <Form.Group controlId="password" size="lg">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            value={fields.password}
            onChange={handleFieldChange}
          />
        </Form.Group>
        <Form.Group controlId="confirmPassword" size="lg">
          <Form.Label>Confirm Password</Form.Label>
          <Form.Control
            type="password"
            onChange={handleFieldChange}
            value={fields.confirmPassword}
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
          Signup
        </LoaderButton>
      </Form>
    );
  }

  return (
    <div className="Signup">
      {renderForm()}
    </div>
  );
}