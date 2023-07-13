import { Component, OnInit } from '@angular/core';
import { DemandeClientType } from '../demande-client-type';
import { DemandeclientService } from '../demandeclient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-acceptedemande',
  templateUrl: './acceptedemande.component.html',
  styleUrls: ['./acceptedemande.component.css']
})
export class AcceptedemandeComponent implements OnInit {
  public typeDemandeclients:DemandeClientType[];
  demandeClientTypeId:number;
  demandeclienttype:DemandeClientType

  constructor(private typedemandeclientservice:DemandeclientService,private router: Router) { }


  ngOnInit(): void {
  }
 /* affecterClientdemande(): void{
    this.typedemandeclientservice.affecterclientAccepte(this.demandeclienttype).subscribe(data => {
        
      this.gotoList();
      },error=>console.log(error));
   
 

  }
  gotoList() {
    this.router.navigate(['/home/client-list']);
  }
*/
client(demandeClientTypeId:number){
  this.router.navigate(['/add-client', demandeClientTypeId]);

}
}
