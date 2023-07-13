import { Component, OnInit,ViewChild,ElementRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Membre } from '../Models/Membre';
import { error } from 'console';
import { MembreService } from '../membre.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {
  membre= new Membre();
  msg ='';
  membreId:number;
  @ViewChild('name') nameKey!: ElementRef;

  loginObj: any = {
    membreAdresseMail:'',
    password:''
  };

  constructor(private service : MembreService,private router: Router,private route : ActivatedRoute) { }

  ngOnInit(): void {
    //this.membreId = +this.route.snapshot.params['membreId']
    
  }
  onLogin() {
    //localStorage.setItem("name",this.nameKey.nativeElement.value);
   // this.loginObj.membreAdresseMail = this.membre.membreAdresseMail;
    
      this.service.loginMembre(this.membre).subscribe(
      (data :any)=> {
        const membreId = data.membreId;
        this.service.currentMembre = data;
        console.log("response received");
      this.router.navigate(['/demande-client'], { queryParams: { membreId: membreId } });
      },
     error => {
      console.log("exception occured")
      this.msg="Bad credentials, please enter valid email or password";
     }
    );
      
    //if(this.loginObj.userName=='user123'&&this.loginObj.password=='user123') {
      

    
      //this.router.navigateByUrl('login/login-user/demande-client')
      
      //alert("sucess")

    
    
  //}else alert("sorry please enter correct Name and Password")
    

}
gotoRegistration() {

  this.router.navigateByUrl('login/login-user/registration')

}
}
