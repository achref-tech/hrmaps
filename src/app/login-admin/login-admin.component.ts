import { Component, OnInit } from '@angular/core';
import { Membre } from '../Models/Membre';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {
  membre:Membre = new Membre();

  loginObj: any = {
    userName:'',
    password:''
  };

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  onLogin() {
    
 if (this.loginObj.userName=='admin123'&&this.loginObj.password=='admin123') {
      this.router.navigateByUrl('home')
      alert("sucess")


    }
    else alert("sorry please enter correct Name and Password")
    
  }

}
