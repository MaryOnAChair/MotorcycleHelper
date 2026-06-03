import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient) { }


  login(username: string,
        password: string) {

    return this.http.post(
      `${this.apiUrl}/login`,
      {
        username,
        password
      },
      {
        responseType: 'text'
      }
    );
  }


  register(user:User){
    return this.http.post(`${this.apiUrl}/register`,user);
  }

  saveToken(token: string):void{
    localStorage.setItem('token', token);
  }
  getToken(){
    return localStorage.getItem('token');

  }

  logout() {
    localStorage.removeItem('token');
  }


}
