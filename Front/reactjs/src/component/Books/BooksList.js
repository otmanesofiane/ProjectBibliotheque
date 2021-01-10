import React, { Component } from 'react';
import {AgGridReact} from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-balham.css';

import BookService from "../../service/book.service";

import "./BooksList.css";

class BookList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      columnDefs: [
        {headerName: 'Id', field: 'id', width: 60, sortable: true, filter: true},
        {headerName: 'Titre', field: 'titre', width: 200,sortable: true, filter: true},
        {headerName: 'Auteur', field: 'auteur', width: 200 ,sortable: true, filter: true},
        {headerName: 'Description', field: 'desc', width: 400,sortable: true, filter: true},
        {headerName: 'Prix €', field: 'price', sortable: true, filter: true}
      ],
      rowData: null
    }
  }

    componentDidMount(){
        BookService.books()
            .then(result => result.json())
            .then(rowData => this.setState({rowData}))
            .catch(err => console.log(err))
    }

  render() {
    return (
        <div className="ag-theme-balham marge" style={{ height: 400, width: 1000 }}>
            <AgGridReact
                columnDefs={this.state.columnDefs}
                rowData={this.state.rowData}
            />
        </div>
    );
  }
}

export default BookList;