import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/user';
import {isPlatformBrowser} from '@angular/common';
import {Inject,PLATFORM_ID} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/auth';

  constructor(private http: HttpClient, @Inject(PLATFORM_ID) private platformId:Object) { }

  loginStatus : boolean | undefined;

  isBrowser():boolean {
    return isPlatformBrowser(this.platformId);
  }

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

  getLoginStatus() {
    return this.loginStatus;
  }


  register(user:User){
    return this.http.post(`${this.apiUrl}/register`,user);
  }

  saveToken(token: string):void{
    if(this.isBrowser()) {
      localStorage.setItem('token', token);
      this.loginStatus = true;
    }
  }

  logout() {
    if(this.isBrowser()) {
      localStorage.removeItem('token');
      this.loginStatus = false;
    }}


}
