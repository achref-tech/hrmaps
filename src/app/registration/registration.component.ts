import { Component, OnInit } from '@angular/core';
import { Membre } from '../Models/Membre';
import { MembreService } from '../membre.service';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  membre= new Membre();
  msg ='';
  
  constructor(private service : MembreService,private router:Router) { }

  ngOnInit(): void {
  }
  Register() {
    this.service.registreMembre(this.membre).subscribe(
      data => {
        console.log("response received")
        this.msg="regisration successful"
        this.router.navigateByUrl('login/login-user')

      },
      error => {
        console.log("exception occrued")
        this.msg=error.error;
      }
    )

  }
  gotoLogin() {

    this.router.navigateByUrl('login/login-user')
  
  }

}
