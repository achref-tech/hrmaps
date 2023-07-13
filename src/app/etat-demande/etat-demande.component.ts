import { Component, OnInit } from '@angular/core';
import { DemandeClientType } from '../demande-client-type';
import { DemandeclientService } from '../demandeclient.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-etat-demande',
  templateUrl: './etat-demande.component.html',
  styleUrls: ['./etat-demande.component.css']
})
export class EtatDemandeComponent implements OnInit {
  demandeClientType: DemandeClientType;
  demandeClientTypeId:number;
  membreId:number;
  employeeNom:string;

  constructor(private service:DemandeclientService,private router:Router,private route : ActivatedRoute) { }


  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.membreId = +params['membreId'] || 0;
      console.log(this.membreId)
      this.loadEmployees();
      /*this.congeService.getCongeByEmployeeId(this.employeeId).subscribe( (data:Conge []) => {
        this.congees = data;
        console.log(this.conge);
      },
      error => console.log(error))*/
    });
      
  }
  loadEmployees() {
    this.service.getDemandeClientTypeByMembreId(this.membreId).subscribe(
      ([data]: DemandeClientType[]) => {
        
        
        this.demandeClientType = data;
        console.log(this.demandeClientType);
      },
      error => console.log(error)
    );
  }

}



