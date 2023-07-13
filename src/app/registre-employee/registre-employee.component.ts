import { Component, OnInit } from '@angular/core';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registre-employee',
  templateUrl: './registre-employee.component.html',
  styleUrls: ['./registre-employee.component.css']
})
export class RegistreEmployeeComponent implements OnInit {
  employee= new Employee();
  msg ='';

  constructor(private service : EmployeeService,private router:Router) { }

  ngOnInit(): void {
  }
    gotoLogin() {

      this.router.navigateByUrl('login/login-employee')
    
    }
    Register(){
      this.service.registreEmployee(this.employee).subscribe(
        data => {
          console.log("response received")
          this.msg="regisration successful"
          this.router.navigateByUrl('login/login-employee')
  
        },
        error => {
          console.log("exception occrued")
          this.msg=error.error;
        }
      )
    }
  }

