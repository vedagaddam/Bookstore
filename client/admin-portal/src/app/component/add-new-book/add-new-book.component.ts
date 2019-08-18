import { Component, OnInit } from '@angular/core';
import {Book} from '../../model/Book';
import {AddBookService} from '../../service/add-book.service';
import { UploadImageService } from 'src/app/service/upload-image.service';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-add-new-book',
  templateUrl: './add-new-book.component.html',
  styleUrls: ['./add-new-book.component.css']
})
export class AddNewBookComponent implements OnInit {
  private newBook: Book = new Book();
  private bookAdded: boolean;	

  constructor(private addBookService:AddBookService, private uploadImageService:UploadImageService) { }

  onSubmit() {
	let  result:Observable<any>=this.addBookService.sendBook(this.newBook);
	result.subscribe(
  		res => {
			res.to
  			this.uploadImageService.upload(res.id);
  			this.bookAdded=true;
  			this.newBook = new Book();
  			this.newBook.active=true;
  			this.newBook.category="Management";
  			this.newBook.language="english";
  			this.newBook.format="paperback";
  		},
  		error => {
  			console.log(error);
  		}
  	);
  }

  ngOnInit() {
  	this.bookAdded=false;
  	this.newBook.active=true;
  	this.newBook.category="Management";
  	this.newBook.language="english";
  	this.newBook.format="paperback";
  }

}
