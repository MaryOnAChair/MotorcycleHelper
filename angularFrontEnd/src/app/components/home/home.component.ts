import {Component, OnInit} from '@angular/core';
import {NavbarComponent} from '../navbar/navbar.component';
import {HttpClient} from '@angular/common/http';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';

import {MotorcycleService} from '../../services/motorcycle.service';
import {Motorcycle} from '../../models/motorcycle';
import {Router, RouterLink} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {from} from 'rxjs';
@Component({
  selector: 'app-home',
  imports: [
    FormsModule,
    NgForOf,
    ReactiveFormsModule,
    RouterLink,


  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {


  motorcycles: Motorcycle[] = [];
  motorcycle: Motorcycle = {
    color: '', vin: 0, moto_id: 0,

    brand: '',

    model: '',

    year: 2023,
    odometer: 0,
  };


  constructor(private http: HttpClient, private MotorcycleService: MotorcycleService,private router: Router,
              private authService: AuthService) {
  }

  ngOnInit(): void{
    this.loadMotorcycles();
  }

  loadMotorcycles(): void {

    this.MotorcycleService
      .getAllMotorcycles()
      .subscribe(data => {

        this.motorcycles = data;
      });
  }




  addMotorcycle(): void {
    this.MotorcycleService
      .createMotorcycle(this.motorcycle)
      .subscribe(() => {

        this.loadMotorcycles();

      });
  }

  deleteMotorcycle(moto_id: number) {
    const confirmed = confirm("Are you sure you want to delete this motorcycle? :(");
    if (!confirmed) { return}

    this.MotorcycleService.deleteMotorcycle(moto_id).subscribe({
      next: () => {
        this.motorcycles = this.motorcycles.filter(motorcycle => motorcycle.moto_id !== moto_id);
      },
      error: (err) => console.error('Delete failed', err)
    });
  }

  editMotorcycle() {
    this.router.navigate(['/editMotorcycle']);
  }



}
