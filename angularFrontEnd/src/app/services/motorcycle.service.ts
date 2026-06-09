import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Motorcycle} from '../models/motorcycle';

@Injectable({
  providedIn: 'root'
})
export class MotorcycleService {

  private apiUrl =     'http://localhost:8080/api/motorcycle';
  private motoId: number = 0;



  constructor( private http: HttpClient ) { }

  getAllMotorcycles():
    Observable<Motorcycle[]> {

    return this.http.get<Motorcycle[]>(
      this.apiUrl
    );
  }
  createMotorcycle(
    motorcycle: Motorcycle,
  ): Observable<Motorcycle> {

    return this.http.post<Motorcycle>(
      this.apiUrl,
      motorcycle
    );
  }

  deleteMotorcycle(
    moto_id: number
  ): Observable<any> {
    return this.http.delete(
      `${this.apiUrl}/${moto_id}`,{responseType: 'text'});

  }

  getMotorcycle(id: string | null){
    return this.http.get<Motorcycle>(`${this.apiUrl}/${id}`);
  }


  updateMotorcycle(moto:Motorcycle){
    return this.http.put(`${this.apiUrl}/${moto.moto_id}`, moto);
  }


}
