import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {NgIf} from '@angular/common';
import {Motorcycle} from '../../models/motorcycle';
import {MotorcycleService} from '../../services/motorcycle.service';
import {NavbarComponent} from '../navbar/navbar.component';
import {Observable} from 'rxjs';
/** This is the  Edit Component for Editing Motorcycle
 * The class is used when editing motorcycles. */

@Component({
  selector: 'app-edit',
  imports: [
    FormsModule,
    NgIf,

  ],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent implements OnInit {
  motorcycle: Motorcycle = {
    color: 'x', vin: 0, moto_id: 0,

    brand: 'c',

    model: 'x',

    year: 2023,
    odometer:0,
  };

  constructor(private route:ActivatedRoute, private motorcycleService:MotorcycleService,private router:Router) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('moto_id'); //Gets current Bike to be edited
    console.log(id);
    this.motorcycleService.getMotorcycle(id).subscribe(data => {
      this.motorcycle = data;
    });
    console.log(id);
  }



  //Cancels Edit
   cancel():void {
    this.router.navigate(['/home']); //Goes back home
  }

  //Updates Motorcycle
   update():void {
    console.log(this.motorcycle);
    this.motorcycleService.updateMotorcycle(this.motorcycle.moto_id,this.motorcycle).subscribe(data => {
      this.router.navigate(['/home']);
    })

  }

  //Generates PDF Receipt
  async generatePdf()
  {

      const ele = document.getElementById('pdf')!;
        const html2pdf = (await import('html2pdf.js')).default;
        const options = {
          margin: 5,
          filename: `receipt-${Date.now()}.pdf`,
          html2canvas: {
            scale: 2,
            useCORS: true
          },

        };
        await html2pdf()
          .set(options)
          .from(ele)
          .save();
        console.log("is working?");

}}
