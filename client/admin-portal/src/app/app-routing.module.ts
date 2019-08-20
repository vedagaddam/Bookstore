import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { WelcomeComponent } from './component/welcome/welcome.component';
import { LogoutComponent } from './component/logout/logout.component';
import { AddNewBookComponent } from './component/add-new-book/add-new-book.component';
import { BookListComponent } from './component/book-list/book-list.component';
import { ViewBookComponent } from './component/view-book/view-book.component';


// const routes: Routes = [
//   {path:'login', component: LoginComponent},

// ];

const routes: Routes = [
	{ path: 'login', component: LoginComponent },
	{ path: 'welcome/:userName', component: WelcomeComponent},
	{ path: '', component: LoginComponent },
	{ path: 'addnewbook', component:AddNewBookComponent},
	{ path: 'logout', component: LogoutComponent },
	{ path: 'booklist', component: BookListComponent},
	{ path: 'viewbook', component: ViewBookComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
