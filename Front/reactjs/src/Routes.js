import React from "react";
import {Switch, Route} from 'react-router-dom';

import AuthenticatedRoute from "./component/Route/AuthenticatedRoute";
import UnauthenticatedRoute from "./component/Route/UnauthenticatedRoute";

import Home from "./component/Home/Home";
import Login from "./component/LoginForm/LoginForm"
import Signup from "./component/SignUp/SignUp"
import Books from "./component/Books/BooksList"
import BooksForm from "./component/BookForm/BookForm"
import NotFound from "./component/NotFound/NotFound";

export default function Routes() {
  return (
    <Switch>
        <UnauthenticatedRoute exact path="/login">
            <Login />
        </UnauthenticatedRoute>
        <UnauthenticatedRoute exact path="/signup">
            <Signup />
        </UnauthenticatedRoute>
        <AuthenticatedRoute exact path="/home">
            <Home />
        </AuthenticatedRoute>
        <AuthenticatedRoute exact path="/books">
            <Books />
        </AuthenticatedRoute>
        <AuthenticatedRoute exact path="/booksform">
            <BooksForm />
        </AuthenticatedRoute>
        <Route>
            <NotFound />
        </Route>
    </Switch>
  );
}