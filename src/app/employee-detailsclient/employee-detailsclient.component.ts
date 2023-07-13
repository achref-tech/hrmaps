import { Component, OnInit } from '@angular/core';
import { Client } from '../Models/Client';
import { ActivatedRoute } from '@angular/router';
import { TypeClientService } from '../services/type-client.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-employee-detailsclient',
  templateUrl: './employee-detailsclient.component.html',
  styleUrls: ['./employee-detailsclient.component.css']
})
export class EmployeeDetailsclientComponent implements OnInit {

  clientId:number
  client:Client
  constructor(private route:ActivatedRoute,private clientService:TypeClientService,private _sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.clientId=this.route.snapshot.params['clientId'];
    this.client=new Client();
    this.clientService.getTypeClient(this.clientId).subscribe(data => {
    this.client=data;
    });
  }
  convert(base64String) {
    return this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64String)
  }

}

