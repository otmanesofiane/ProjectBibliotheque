import React from "react";

export default function Home() {

  const user = JSON.parse(localStorage.getItem("user")).username

    return (
      <div className="Home">
        <div className="lander">
          <h1>Bibliothèque</h1>
          <p className="text-muted">Welcome {user} !</p>
        </div>
      </div>
    );
  }