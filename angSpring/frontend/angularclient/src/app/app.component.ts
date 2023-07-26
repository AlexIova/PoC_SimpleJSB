import { Component } from '@angular/core';

@Component({
  selector: 'app-root',                         // Usato per bindarci al componente HTML 
  templateUrl: './app.component.html',          // Il template file HTML associato con questo component
  styleUrls: ['./app.component.css']            // CSS files associati cn il component
})


export class AppComponent {

  title: string;

  constructor() {
    this.title = "Spring Boot & Angular Application";
  }

}
