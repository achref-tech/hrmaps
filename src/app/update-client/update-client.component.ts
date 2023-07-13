import { Component, OnInit } from '@angular/core';
import { Client } from '../Models/Client';
import { TypeClientService } from '../services/type-client.service';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClientComponent implements OnInit {
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
    this.router.navigate(['/home/client-list']);
  }

}

  


