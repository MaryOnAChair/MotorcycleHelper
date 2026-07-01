import { Component } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {FormBuilder, FormsModule} from '@angular/forms';
import {User} from '../../models/user';
import {Router, RouterLink} from '@angular/router';
import {NgIf} from '@angular/common';
/** This is the  Register Component for User Registration
 * The class is used when registering in users. */

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
  //Registers User
  register() {
    console.log(this.user);
    this.auth.register(this.user).subscribe({
      next: (res:any)=>{
        alert(res.message||res);
        this.router.navigate(['/login']); //Reroutes to Log in

      },
      error: (err)=>{
        alert(err.error||err);
      }
    });
  }

}
