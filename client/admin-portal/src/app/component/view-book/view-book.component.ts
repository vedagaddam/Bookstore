import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/model/Book';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {

  constructor() { }
  book:Book;

  ngOnInit() {
  }
  notifyBook($event){
   this.book=$event;
  }
}
