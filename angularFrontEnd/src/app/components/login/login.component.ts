import {Component, OnInit} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {FormsModule} from '@angular/forms';
import {User} from '../../models/user';
/** This is the  Login Component for User Login
 * The class is used when Logging in users. */

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

  //Logs users in
  login() {

    this.auth.login(
      this.username,
      this.password)
      .subscribe({

        next: (token) => {

          //Save token
          this.auth
            .saveToken(token);

          //Reroutes to Home after log in
          this.router.navigate(
            ['/home']);
        },

        error: (err) => {
          console.log(err);
        }

      });
  }
}




