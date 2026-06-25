import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {NgIf} from '@angular/common';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  imports: [RouterLink, NgIf],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
    constructor(private authService: AuthService,private router: Router) { }
  checkLogin() {
    return this.authService.getLoginStatus();
  }
  logOut() {
    console.log('Logged out pressed!');
    this.authService.logout();
    this.router.navigate(['/']);
  }

}
