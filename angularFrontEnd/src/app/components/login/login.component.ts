import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [
    RouterLink,
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username = '';
  password = '';

  constructor(private auth: AuthService) {
  }


  protected readonly RouterLink = RouterLink;

  login(){
    const body =-{
      username: this.username,
      password: this.password
    };
    this.auth.login(body).subscribe({
      next: (result) => {
        this.auth.saveToken(result.token)
        console.log("logged in works");
      },
      error: (error) => {
        alert('incorrect credentials');
      }
    });
  }
}
