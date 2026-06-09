import { Component } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {FormsModule} from '@angular/forms';
import {User} from '../../models/user';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    RouterLink
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user: User = new User();


  constructor(private auth: AuthService) {
  }
  register() {
    console.log(this.user);
    this.auth.register(this.user).subscribe({
      next: ()=>{
        alert("User registered successfully");
      },
      error: (err)=>{
        alert(err.error);
      }
    });
  }

}
