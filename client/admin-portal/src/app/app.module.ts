import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import 'hammerjs';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { DemoMaterialModule } from './material-module';
import { LoginComponent } from './component/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MenuComponent } from './component/menu/menu.component';
import { LogoutComponent } from './component/logout/logout.component';
import { FooterComponent } from './component/footer/footer.component';
import { WelcomeComponent } from './component/welcome/welcome.component';
import { AddNewBookComponent } from './component/add-new-book/add-new-book.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { BookListComponent } from './component/book-list/book-list.component';
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
    MenuComponent,
    LogoutComponent,
    FooterComponent,
    WelcomeComponent,
    AddNewBookComponent,
    BookListComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    DemoMaterialModule,
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
  
})
export class AppModule { }
