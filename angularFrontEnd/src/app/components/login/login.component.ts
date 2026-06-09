import {Component, OnInit} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {FormsModule} from '@angular/forms';
import {User} from '../../models/user';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
    RouterLink
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent  {

  username: string = "";
  password: string = "";



  constructor(private auth: AuthService, private router: Router,
              ) {
  }

  login() {

    this.auth.login(
      this.username,
      this.password)
      .subscribe({

        next: (token) => {

          this.auth
            .saveToken(token);

          this.router.navigate(
            ['/home']);
        },

        error: (err) => {
          console.log(err);
        }

      });
  }
}




