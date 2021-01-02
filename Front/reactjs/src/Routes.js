import React from "react";
import {Switch, Route} from 'react-router-dom';

import Home from "./component/Home/Home";
import Login from "./component/LoginForm/LoginForm"
import Signup from "./component/SignUp/SignUp"
import NotFound from "./component/NotFound/NotFound";

export default function Routes() {
  return (
    <Switch>
        <Route exact path="/">
            <Home />
        </Route>
        <Route exact path="/login">
            <Login />
        </Route>
        <Route exact path="/signup">
            <Signup />
        </Route>
        <Route>
            <NotFound />
        </Route>
    </Switch>
  );
}