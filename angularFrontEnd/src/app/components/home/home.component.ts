import {Component, OnInit} from '@angular/core';
import {NavbarComponent} from '../navbar/navbar.component';
import {HttpClient} from '@angular/common/http';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';

import {MotorcycleService} from '../../services/motorcycle.service';
import {Motorcycle} from '../../models/motorcycle';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [
    FormsModule,
    NgForOf,
    ReactiveFormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  motorcycles: Motorcycle[] = [];
  motorcycle: Motorcycle = {
    color: '', last_oil_change_date: '', moto_id: 0,

    brand: '',

    model: '',

    year: 2023
  };

  constructor(private http: HttpClient, private MotorcycleService: MotorcycleService) {
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
    this.MotorcycleService.deleteMotorcycle(moto_id).subscribe({
      next: () => {
        this.motorcycles = this.motorcycles.filter(motorcycle => motorcycle.moto_id !== moto_id);
      },
      error: (err) => console.error('Delete failed', err)
    });
  }

}
