import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {NgIf} from '@angular/common';
import {AuthService} from '../../services/auth.service';

/** This is the  NavBar Component for displaying the Navigation Bar
 * Has Home,About and LogOut buttons*/

@Component({
  selector: 'app-navbar',
  imports: [RouterLink, NgIf],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
    constructor(private authService: AuthService,private router: Router) { }
  //Checks for Login Status
  checkLogin() {
    return this.authService.getLoginStatus();
  }
  //Logs User out
  logOut() {
    console.log('Logged out pressed!');
    this.authService.logout();
    this.router.navigate(['/']);
  }

}
