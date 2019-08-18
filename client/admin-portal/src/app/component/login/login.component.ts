import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { LoginService } from 'src/app/service/login.service';
import { Observable } from 'rxjs';
import { Book } from 'src/app/model/Book';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  router: Router;
  loginForm: FormGroup;
  builder: FormBuilder;
  loginService: LoginService;
  invalidLogin: Boolean = false;
  loggedIn:Boolean= false;
  bookAdded: boolean;
  private newBook: Book=new Book();
  constructor(router: Router, builder: FormBuilder, loginService: LoginService) {
    this.router = router;
    this.builder = builder;
    this.loginService = loginService;
  }
  userName = '';
  password = '';
  loginCredentials = false;
  errorMessage = 'InvalidCredentials';

  handleLogin() {
    console.log(this.userName)
    console.log(this.password)
   let  result:Observable<any> = this.loginService.getLoginToken(this.userName,this.password);
   return result.subscribe(
     result=>{
      this.loginCredentials = false;
      sessionStorage.setItem('xAuthToken',result.token);
      this.router.navigate(['welcome', this.userName]);
     },
     error=>{
      this.loginCredentials = true;
      //this.router.navigate(['error'])
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