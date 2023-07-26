import { NgModule } from "@angular/core";
import { UserFormComponent } from "./user-form/user-form.component";
import { UserListComponent } from "./user-list/user-list.component";
import { RouterModule, Routes } from "@angular/router";

const routes: Routes = [
    { path: 'users', component: UserListComponent },
    { path: "adduser", component: UserFormComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }