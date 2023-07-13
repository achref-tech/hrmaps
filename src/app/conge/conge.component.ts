import { Component, OnInit } from '@angular/core';
import { CongeService } from '../service/conge.service';
import { Conge } from '../Models/Conge';
import { ActivatedRoute, Router } from '@angular/router';
import { Etat } from '../Models/Etat';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-conge',
  templateUrl: './conge.component.html',
  styleUrls: ['./conge.component.css']
})
export class CongeComponent implements OnInit {
  startDate: Date;
  endDate: Date;
  id:number;
  reason: string;
  name:string;
  etat : Etat
 //employeeId:Employee;
 employee: Employee = new Employee();
  employeeId:number;
  public employees:Employee[];

  //employeeId:number;

  conge:Conge=new Conge();


  constructor(private service:CongeService,private router: Router,private servicee:EmployeeService,private route : ActivatedRoute) { }
  newConge(): void {
    this.conge = new Conge();
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.employeeId = +params['employeeId'] || 0;
      console.log(this.employeeId)
    
    this.servicee.getEmployee(this.employeeId).subscribe((data:Employee) => {
      //const employeeId = data.employeeId;
      //this.router.navigate(['/accepte-demandeconge'], { queryParams: { employeeId: employeeId } });
      this.employee = data;
     console.log(this.employee);
      
    }, error=>console.log(error));
  });
  this.loadEmployees();
  }
  loadEmployees() {
    this.servicee.getEmployee(this.employeeId).subscribe(
      (data: Employee[]) => {
        this.employees = data;
      },
      error => console.log(error)
    );
  }
  onSubmit() {
    /*
   const conge: Conge = {
      id: 0,
      startDate: this.startDate,
      endDate: this.endDate,
      reason: this.reason,
      name:this.name,
      etat:this.etat,
      employee:this.employee
    };*/
    
    console.log(this.employeeId)
    this.service.createConge(this.conge,this.employeeId).subscribe(
      (data) => {
        console.log(data);
        this.startDate = new Date();;
      this.endDate = new Date();;
      this.reason = '';
      
        this.gotoList();
      },
      (error) => console.log(error)
    );
  }
  
  gotoList(){
    this.router.navigate(['/accepte-demandeconge'], { queryParams: { employeeId: this.employeeId } });
  }
}










