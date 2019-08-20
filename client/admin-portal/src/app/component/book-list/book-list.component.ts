import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { BookListService } from 'src/app/service/book-list.service';
import { Book } from 'src/app/model/Book';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
 
  @Output() onBookClick = new EventEmitter<Book>();
  
  @Input()  selectedBook: Book;
  constructor( private bookListService:BookListService, private router: Router) { }
  books:Book[];
  

  ngOnInit() {
   let bookList:Observable<Array<Book>>= this.bookListService.viewBookList();
    bookList.subscribe(res=>{
      this.books = res;

    },error=>{});
  }

  viewBookDetails(book: Book){
    console.log(book);
    this.selectedBook = book;
    this.onBookClick.emit(this.selectedBook);
    this.router.navigate(['viewbook']);
  }
  

}
