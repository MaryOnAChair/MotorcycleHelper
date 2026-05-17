import {Component, OnInit} from '@angular/core';
import {NavbarComponent} from '../navbar/navbar.component';
import {HttpClient} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';

import {MotorcycleService} from '../../services/motorcycle.service';
import {Motorcycle} from '../../models/motorcycle';

@Component({
  selector: 'app-home',
  imports: [
    FormsModule,
    NgForOf
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  motorcycles: Motorcycle[] = [];
  motorcycle: Motorcycle = {
    last_oil_change_date: '', moto_id: 0,
    color: '',
    brand: "",
    model: "",
    year: 2023
  };

  constructor(private http: HttpClient, private motorcycleService: MotorcycleService) {
  }

  ngOnInit(): void{
    this.loadMotorcycles();
  }

  loadMotorcycles(): void {

    this.motorcycleService
      .getAllMotorcycles()
      .subscribe(data => {

        this.motorcycles = data;
      });
  }



  addMotorcycle(): void {
    this.motorcycleService
      .createMotorcycle(this.motorcycle)
      .subscribe(() => {

        this.loadMotorcycles();

      });
  }

}
