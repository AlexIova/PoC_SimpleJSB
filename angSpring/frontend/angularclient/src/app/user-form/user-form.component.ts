import { Component } from '@angular/core';
import { Utente } from '../model/utente';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})


export class UserFormComponent {

  user: Utente;

  constructor( private route: ActivatedRoute, private router: Router, private userService: UserService) {
    this.user = new Utente();
  }


  onSubmit() {
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList(){
    this.router.navigate(["/users"]);
  }


}
