import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Motorcycle} from '../models/motorcycle';

/** This is the front end Motorcycle Service
 * The class is used when adding/updating/deleting motorcycles. */

@Injectable({
  providedIn: 'root'
})
export class MotorcycleService {

  private apiUrl =     '/api/motorcycle';
  private motoId: number = 0;



  constructor( private http: HttpClient ) { }

  //Gets all motorcycles
  getAllMotorcycles():
    Observable<Motorcycle[]> {

    return this.http.get<Motorcycle[]>(
      this.apiUrl
    );
  }

  //Creates Motorcycle
  createMotorcycle(
    motorcycle: Motorcycle,
  ): Observable<Motorcycle> {

    return this.http.post<Motorcycle>(
      this.apiUrl,
      motorcycle
    );
  }

  //Deletes Motorcycle
  deleteMotorcycle(
    moto_id: number
  ): Observable<any> {
    return this.http.delete(
      `${this.apiUrl}/${moto_id}`,{responseType: 'text'});

  }

  //Gets Motorcycle by ID
  getMotorcycle(id: string | null){
    return this.http.get<Motorcycle>(`${this.apiUrl}/${id}`);
  }

//Updates motorcycle
  updateMotorcycle(id:number,moto:Motorcycle):Observable<Motorcycle> {
    return this.http.put<Motorcycle>(`${this.apiUrl}/${moto.moto_id}`, moto);
  }



}
