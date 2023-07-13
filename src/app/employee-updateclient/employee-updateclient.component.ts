import { Component, OnInit } from '@angular/core';
import { Client } from '../Models/Client';
import { TypeClientService } from '../services/type-client.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-employee-updateclient',
  templateUrl: './employee-updateclient.component.html',
  styleUrls: ['./employee-updateclient.component.css']
})
export class EmployeeUpdateclientComponent implements OnInit {


  clientId:number;
  
  client: Client = new Client();
  constructor(private clientservice : TypeClientService , 
    private route : ActivatedRoute ,
    private router:Router) { }


  ngOnInit(): void {
    this.clientId = this.route.snapshot.params['clientId']
    
    this.clientservice.getTypeClient(this.clientId).subscribe(data => {
      this.client = data;
    }, error=>console.log(error));
    
    
  }
  updateClientType(): void {
    this.clientservice.updateTypeClient(this.clientId,this.client).subscribe(data => {
    this.gotoList();
    },error=>console.log(error));
    
  }
  


  gotoList() {
    this.router.navigate(['/employee-listclient']);
  }

}

  



