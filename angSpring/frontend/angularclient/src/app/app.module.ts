import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { UserListComponent } from "./user-list/user-list.component";
import { UserFormComponent } from "./user-form/user-form.component";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { UserService } from "./service/user.service";
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }