import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import Form from "react-bootstrap/Form";
import LoaderButton from "../LoaderButton/LoaderButton";
import "./LoginForm.css";
import { useAppContext } from "../../libs/contextLib";
import { useFormFields } from "../../libs/hooksLib";

export default function Login() {

    const history = useHistory();
    const [isLoading, setIsLoading] = useState(false);
    const { userHasAuthenticated } = useAppContext();
    const [fields, handleFieldChange] = useFormFields({
      email: "",
      password: ""
    });

    function validateForm() {
        return fields.email.length > 0 && fields.password.length > 0;
    }

    function saveStateToLocalStorage () {
      localStorage.setItem('user', 'true')
    }

    function handleSubmit(event) {
        event.preventDefault();
        setIsLoading(true);
        try {
          if(fields.email == "admin@admin" & fields.password == "admin"){
            alert("logged")
            saveStateToLocalStorage()
            userHasAuthenticated(true);
            history.push("/");
          } else {
            alert("Logged fail")
            setIsLoading(false);
          }
        } catch (e) {
          alert(e.message);
          setIsLoading(false);
        }
    }

    return (
        <div className="Login">
          <Form onSubmit={handleSubmit}>
            <Form.Group size="lg" controlId="email">
              <Form.Label>Email</Form.Label>
              <Form.Control
                autoFocus
                type="email"
                value={fields.email}
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
        </div>
    );
}