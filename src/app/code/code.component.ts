import { Component, OnInit } from '@angular/core';
import { Employee } from '../Models/Employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-code',
  templateUrl: './code.component.html',
  styleUrls: ['./code.component.css']
})
export class CodeComponent implements OnInit {
employee:Employee=new Employee();
loginObj: any = {
  code:''
}
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  code(){
    if (this.loginObj.code=='a1b2c3d4') {
      this.router.navigateByUrl('login/login-employee')
      alert("sucess")


    }
    else alert("sorry please enter correct Code")
    
  }
  }


