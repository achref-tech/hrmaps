import { Component, OnInit } from '@angular/core';
import { Employee } from '../Models/Employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-login-employee',
  templateUrl: './login-employee.component.html',
  styleUrls: ['./login-employee.component.css']
})
export class LoginEmployeeComponent implements OnInit {
  employee= new Employee();
  msg ='';
  employeeId:number;
  loginObj: any = {
    employeeAdresseMail:'',
    employeeMdp:''
  };

  constructor(private service : EmployeeService,private router: Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
  }
  onLogin() {
  this.service.loginEmployee(this.employee).subscribe(
    (data :any)=> {
      const employeeId = data.employeeId;
      console.log("response received");
    this.router.navigate(['/welcome-employee'], { queryParams: { employeeId: employeeId } });
    },
   error => {
    console.log("exception occured")
    this.msg="Bad credentials, please enter valid email or password";
   }
  );
  }

  gotoRegistration() {

    this.router.navigateByUrl('login/login-employee/registre-employee')
  
  }

}
