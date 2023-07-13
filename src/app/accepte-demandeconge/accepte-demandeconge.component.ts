import { Component, OnInit } from '@angular/core';
import { CongeService } from '../service/conge.service';
import { ActivatedRoute } from '@angular/router';
import { Conge } from '../Models/Conge';

@Component({
  selector: 'app-accepte-demandeconge',
  templateUrl: './accepte-demandeconge.component.html',
  styleUrls: ['./accepte-demandeconge.component.css']
})
export class AccepteDemandecongeComponent implements OnInit {
  conge: Conge;
  id:number;
  employeeId:number;
  //public congees:Conge[];
  //conge: Conge = new Conge();

  constructor( private route: ActivatedRoute,

    private congeService: CongeService) { }


  ngOnInit(): void {
   // console.log(this.id)
    
    this.route.queryParams.subscribe(params => {
      this.employeeId = +params['employeeId'] || 0;
      console.log(this.employeeId)
      this.loadEmployees();
      /*this.congeService.getCongeByEmployeeId(this.employeeId).subscribe( (data:Conge []) => {
        this.congees = data;
        console.log(this.conge);
      },
      error => console.log(error))*/
    });
      
  }
  loadEmployees() {
    this.congeService.getCongeByEmployeeId(this.employeeId).subscribe(
      ([data]: Conge[]) => {
        
        
        this.conge = data;
        console.log(this.conge);
      },
      error => console.log(error)
    );
  }
  }

