import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../model/Book';


@Injectable({
  providedIn: 'root'
})
export class BookListService {
  constructor( private httpClient:HttpClient){

  }
  viewBookList(): Observable<any> {
    let url = "http://localhost:8080/book/bookList";
    
    let headers = new HttpHeaders ({
      'Content-Type': 'application/json',
      'x-auth-token' : sessionStorage.getItem('xAuthToken')
    });
   return  this.httpClient.get(url,{headers:headers});
   
  }
}
