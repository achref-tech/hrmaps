import { Component, OnInit } from '@angular/core';
import { Membre } from '../Models/Membre';
import { MembreService } from '../membre.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-demande-client',
  templateUrl: './demande-client.component.html',
  styleUrls: ['./demande-client.component.css']
})
export class DemandeClientComponent implements OnInit {
  public membres: Membre[];
  msg ='';
  //public name:string="";
  membre: Membre = new Membre();
  membreAdresseMail:string="";

  membreId:number;
  membreNom: string;
  membrePrenom:string;
  name: string;

  loginObj: any = {
    membreAdresseMail:'',
    password:''
  };

  constructor(private route : ActivatedRoute ,
    private router:Router,private service:MembreService) { }

  ngOnInit(): void {
    this.membre= this.service.currentMembre!;
    //this.name = localStorage.getItem("name")!;
    //this.membreNom = this.name;
   // this.name=localStorage.getItem("name")!;
    //this.nomMembre = this.name;
    //this.membreId = +this.route.snapshot.params[('membreId')]!;
    this.route.queryParams.subscribe(params => {
      this.membreId = +params['membreId'] || 0;
    });

    this.service.getMembre(this.membreId).subscribe(data => {
      this.membre = data;
      console.log(this.membre);
    }, error=>console.log(error));
  }
  Typedemande(){
    this.service.loginMembre(this.membre).subscribe(
      (data :any)=> {
        const  membreId = data. membreId;
        console.log("response received");
      this.router.navigate(['/demande-client/add-demandeclient'], { queryParams: { membreId: membreId } });
      },
     error => {
      console.log("exception occured")
      this.msg="Bad credentials, please enter valid email or password";
     }
    );  
  }
  demande(){
    this.service.loginMembre(this.membre).subscribe(
      (data :any)=> {
        const membreId = data.membreId;
        console.log("response received");
      this.router.navigate(['/etat-demande'], { queryParams: { membreId: membreId } });
      },
     error => {
      console.log("exception occured")
      this.msg="Bad credentials, please enter valid email or password";
     }
    );
  }
  
}
  


