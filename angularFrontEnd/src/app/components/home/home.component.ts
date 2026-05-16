import {Component, OnInit} from '@angular/core';
import {NavbarComponent} from '../navbar/navbar.component';
import {HttpClient} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';

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
  motorcyles: any[]=[];
  motorcyle = {
    brand: " ",
    model: " ",
    year: " "
  };
  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.loadMotorcycles();
  }

  loadMotorcycles() {
    this.http.get<any[]>("http://localhost:8080/garage").subscribe((data: any) => {
      this.motorcyles = data;
    });
  }

  addMotorcycle(){
    this.http.post("http://localhost:8080/garage",
      this.motorcyle
    ).subscribe((data: any) => {
      this.loadMotorcycles();
    });
  }

}
