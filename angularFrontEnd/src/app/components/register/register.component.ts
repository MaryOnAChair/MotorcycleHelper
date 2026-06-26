import { Component } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {FormBuilder, FormsModule} from '@angular/forms';
import {User} from '../../models/user';
import {Router, RouterLink} from '@angular/router';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    RouterLink,
    NgIf
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user: User = new User();


  constructor(private auth: AuthService,private router: Router, ) {
  }
  register() {
    console.log(this.user);
    this.auth.register(this.user).subscribe({
      next: (res:any)=>{
        alert(res.message||res);
        this.router.navigate(['/login']);

      },
      error: (err)=>{
        alert(err.error||err);
      }
    });
  }

}
