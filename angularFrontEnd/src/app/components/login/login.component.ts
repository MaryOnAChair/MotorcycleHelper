import { Component } from '@angular/core';
import {RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {FormsModule} from '@angular/forms';
import {User} from '../../models/user';

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

  user: User = new User();

  constructor(private auth: AuthService) {
  }


  protected readonly RouterLink = RouterLink;

  login(){

    this.auth.login(this.user).subscribe({
      next: (result:any) => {
        console.log(result);
        this.auth.saveToken(result.token)
        console.log("logged in works");
      },
      error: (error) => {
        alert('incorrect credentials');
      }
    });
  }
}
