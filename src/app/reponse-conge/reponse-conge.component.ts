import { Component, OnInit } from '@angular/core';
import { CongeService } from '../service/conge.service';
import { ActivatedRoute } from '@angular/router';
import { Conge } from '../Models/Conge';

@Component({
  selector: 'app-reponse-conge',
  templateUrl: './reponse-conge.component.html',
  styleUrls: ['./reponse-conge.component.css']
})
export class ReponseCongeComponent implements OnInit {
  conge: Conge;
  id:number;
  employeeId:number;

  constructor(private route: ActivatedRoute,

    private congeService: CongeService) { }

  ngOnInit(): void {
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
