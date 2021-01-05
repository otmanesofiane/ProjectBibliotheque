import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import Form from "react-bootstrap/Form";
import LoaderButton from "../LoaderButton/LoaderButton";
import "./LoginForm.css";
import { useAppContext } from "../../libs/contextLib";
import { useFormFields } from "../../libs/hooksLib";

import AuthService from "../../service/auth.service";

export default function Login() {

    const [isLoading, setIsLoading] = useState(false);
    const { userHasAuthenticated } = useAppContext();
    const [fields, handleFieldChange] = useFormFields({
      username: "",
      password: ""
    });
    const history = useHistory();

    function validateForm() {
        return fields.username.length > 0 && fields.password.length > 0;
    }

    function handleSubmit(event) {
        event.preventDefault();

        const user = {
          username: fields.username,
          password: fields.password
        };

        setIsLoading(true);

        AuthService.login(user.username, user.password).then(
          () => {
            alert("logged")
            history.push("/");
            userHasAuthenticated(true);
          },
          error => {
            const resMessage =
              (error.response &&
                error.response.data &&
                error.response.data.message) ||
              error.message ||
              error.toString();
  
              alert(resMessage);
              setIsLoading(false);
          }
        );
    }

    return (
      
        <div className="Login">
          <Form onSubmit={handleSubmit}>
            <Form.Group size="lg" controlId="username">
              <Form.Label>username</Form.Label>
              <Form.Control
                autoFocus
                type="text"
                value={fields.username}
                onChange= {handleFieldChange}
              />
            </Form.Group>
            <Form.Group size="lg" controlId="password">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                value={fields.password}
                onChange= {handleFieldChange}
              />
            </Form.Group>
            <LoaderButton
                block
                size="lg"
                type="submit"
                isLoading={isLoading}
                disabled={!validateForm()}>
                Login
            </LoaderButton>
          </Form>
          <span>admin@admin | admin</span>
        </div>
        
    );
}