import { Component, OnInit } from '@angular/core';
import { Client } from '../Models/Client';
import { TypeClientService } from '../services/type-client.service';
import { ActivatedRoute } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';


@Component({
  selector: 'app-client-versionrecent',
  templateUrl: './client-versionrecent.component.html',
  styleUrls: ['./client-versionrecent.component.css']
})
export class ClientVersionrecentComponent implements OnInit {
  clientId:number;
  clientVolonte:number;
  client:Client;
  max:number;
  
  constructor(private route:ActivatedRoute,private clientService:TypeClientService,private _sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.clientId=this.route.snapshot.params['clientId'];
    this.client=new Client();
    this.clientService.findClientByRecentVersion().subscribe(data => {
      this.client=data;
      console.log(this.client)
    })
  }
  convert(base64String) {
    return this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64String)
  }

}
