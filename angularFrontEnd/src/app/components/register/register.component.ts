import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-register',
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user:any={};
  constructor(private authService: AuthService, private router: Router) {}

  register() {
    this.authService.register(this.user).subscribe(() => {
      this.router.navigate(['/login']);
    }, error => {
      console.error('Registration error: ', error);
    });
  }

}
