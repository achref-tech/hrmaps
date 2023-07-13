import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../Models/Employee';

@Component({
  selector: 'app-welcome-employee',
  templateUrl: './welcome-employee.component.html',
  styleUrls: ['./welcome-employee.component.css']
})
export class WelcomeEmployeeComponent implements OnInit {
  public employees: Employee[];
  msg ='';
  //public name:string="";
  employee: Employee = new Employee();

  employeeAdresseMail:string="";

  employeeId:number;
  employeeNom: string="";
  employeePrenom:string;
  name: string;

  loginObj: any = {
    membreAdresseMail:'',
    password:''
  };

  constructor(private route : ActivatedRoute ,
    private router:Router,private service:EmployeeService) { }

  ngOnInit(): void {
   
  
    this.route.queryParams.subscribe(params => {
      this.employeeId = +params['employeeId'] || 0;
    
    this.service.getEmployee(this.employeeId).subscribe((data:Employee) => {
      
      this.employee = data;
      console.log(this.employee);

      
    }, error=>console.log(error));
  })

}
TypeClient() {
  this.service.loginEmployee(this.employee).subscribe(
    (data :any)=> {
      const employeeId = data.employeeId;
      console.log("response received");
    this.router.navigate(['/employee-listdemandeclient'], { queryParams: { employeeId: employeeId } });
    },
   error => {
    console.log("exception occured")
    this.msg="Bad credentials, please enter valid email or password";
   }
  );
  }
  TypeClientt() {
    this.service.loginEmployee(this.employee).subscribe(
      (data :any)=> {
        const employeeId = data.employeeId;
        console.log("response received");
      this.router.navigate(['/conge'], { queryParams: { employeeId: employeeId } });
      },
     error => {
      console.log("exception occured")
      this.msg="Bad credentials, please enter valid email or password";
     }
    );
    }
    reponse(){
      this.service.loginEmployee(this.employee).subscribe(
        (data :any)=> {
          const employeeId = data.employeeId;
          console.log("response received");
        this.router.navigate(['/reponse-conge'], { queryParams: { employeeId: employeeId } });
        },
       error => {
        console.log("exception occured")
        this.msg="Bad credentials, please enter valid email or password";
       }
      );
      
    }
}
