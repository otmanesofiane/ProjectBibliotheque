import React, { Component } from 'react';
import {AgGridReact} from 'ag-grid-react';

import Button from 'react-bootstrap/Button';

import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-alpine.css';
import 'bootstrap/dist/css/bootstrap.min.css';


import BookService from "../../service/book.service";
import RentService from "../../service/rent.service";

import "./BooksList.css";

const actionButton=(params)=>{
  var today = new Date();
  var dd = String(today.getDate()).padStart(2, '0');
  var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
  var mmEnd = String(today.getMonth()+2).padStart(2, '0');;
  var yyyy = today.getFullYear();

  var debutLocation = dd + '/' + mm + '/' + yyyy;
  var finLocation = dd + '/' + mmEnd + '/' + yyyy;

  var idBook = params.data.id
  var username = JSON.parse(localStorage.getItem("user")).username
  
  var rent = {
    debutLocation : debutLocation,
    finLocation : finLocation
  }

  RentService.addRent(idBook, username, rent)
  .then(
    response => {
      alert("Livre loué")
      window.location.reload(false);
    }, 
    error => {
      const resMessage =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();
        alert(resMessage)
    })

}

class BookList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      columnDefs: [
        {headerName: 'Id', field: 'id', width: 60, sortable: true, filter: true},
        {headerName: 'Titre', field: 'titre', width: 200,sortable: true, filter: true},
        {headerName: 'Auteur', field: 'auteur', width: 200 ,sortable: true, filter: true},
        {headerName: 'Description', field: 'desc', width: 400,sortable: true, filter: true},
        {headerName: 'Prix €', field: 'price', sortable: true, filter: true},
        {headerName: 'Action', field: 'isRented',
        cellRendererFramework:(params)=>
        <div>
          { !params.data.isRented ? (<button className = "btn" onClick={()=>actionButton(params)}>Louer</button>) : ("Déjà loué")}
        </div>}
      ],
      rowData: null
    }
  }

    componentDidMount(){
        BookService.books()
            .then(result => result.json())
            .then(rowData => this.setState({rowData}))
            .catch(err => alert(err))
    }

  render() {
    return (
        <div className="ag-theme-alpine marge" style={{ height: 400, width: 1200 }}>
            <AgGridReact
                columnDefs={this.state.columnDefs}
                rowData={this.state.rowData}
                defaultColDef={{flex:1}}
            />
        </div>
    );
  }
}

export default BookList;