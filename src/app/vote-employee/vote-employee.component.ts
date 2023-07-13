import { Component, OnInit } from '@angular/core';
import { Employee } from '../Models/Employee';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-vote-employee',
  templateUrl: './vote-employee.component.html',
  styleUrls: ['./vote-employee.component.css']
})
export class VoteEmployeeComponent implements OnInit {

  demandeClientTypeId: number;
  votedEmployees: Employee[];
  //employee:Employee;
  employeeNom:string;

  constructor(
    private route: ActivatedRoute,
    private employeeService: EmployeeService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.demandeClientTypeId = +params['demandeClientTypeId']|| 0;
      console.log(this.demandeClientTypeId)

  
      // Récupérer la liste des employees votants pour le demandeClientTypeId donné
      this.employeeService.getVotedEmployees(this.demandeClientTypeId).subscribe(
        (employee: Employee[]) => {
          //this.votedEmployees = response;
          this.votedEmployees = employee;
          console.log(this.votedEmployees); // Check if the data is received correctly
        },
        error => console.log(error)
      );
    });
}
}
