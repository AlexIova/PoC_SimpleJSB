import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Utente } from '../model/utente';
import { Observable } from 'rxjs';


@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<Utente[]> {
    return this.http.get<Utente[]>(this.usersUrl);
  }

  public save(user: Utente) {
    return this.http.post<Utente>(this.usersUrl, user);
  }

}
