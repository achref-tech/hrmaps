import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Client } from '../Models/Client';
import { MatTableDataSource } from '@angular/material/table';
import { Version } from '@angular/compiler';
import { TypeClientService } from '../services/type-client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { VersionserviceService } from '../versionservice.service';


@Component({
  selector: 'app-affecterversionclient',
  templateUrl: './affecterversionclient.component.html',
  styleUrls: ['./affecterversionclient.component.css']
})
export class AffecterversionclientComponent implements OnInit, AfterViewInit {

  versionId: number;
  clientId: number;
  clientDateDebutDemande: Date;
  clientDateFinDemande: Date;
  displayedColumns = [
    'versionId',
    'versionEmplacement',
    'versionLibelle',
    'versionResponsable',
    'operations',
  ];
  dataSource = new MatTableDataSource();
  client: Client;
  //public versions: Version[];
  version : Version;

  constructor(private clientService: TypeClientService
    , private versionService: VersionserviceService,
    private router: Router
    , private route: ActivatedRoute) { }

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;
  
    ngAfterViewInit() {
      //this.dataSource.paginator = this.paginator;
      //this.dataSource.sort = this.sort;
    }
  
    getClient(id: number) {
      // console.log("ID : "+id)
      this.client = new Client;
      this.clientService.getTypeClient(id).subscribe(res => {
        this.client.clientId = res.clientId
        this.client.clientVolonte = res.clientVolonte
        this.client.clientDescription = res.clientDescription
        this.client.clientDateDebutDemande = res.clientDateDebutDemande
        this.client.clientDateFinDemande = res.clientDateFinDemande
        this.client.etat = res.etat
        this.client.version = res.version
        this.client.clientTypeId = res.clientTypeId
        this.client.clientType = res.clientType
        this.client.image=res.image
  
        console.log(this.client)
  
  
  
  
        // console.log(this.reunion)
      })
    }
    
  
    ngOnInit(): void {
      this.getClient(this.route.snapshot.params['clientId'])
      this.reloadData();
      console.log(this.client)
  
    }
    reloadData() {
      this.versionService.getVersion().subscribe((data) => {
        this.dataSource.data = data;
        // console.log(this.dataSource.data);
      })
  
      
    };
  
  
  
  
  
    //HERE
    affecterClientVersion(versionId: number): void {
  
      console.log("version ", versionId);
  
      this.clientService.affecterVersionclient(versionId, this.client).subscribe(data => {
        
           this.gotoList();
           },error=>console.log(error));
        
      
    }
  
  
  
  
  
    gotoList() {
      this.router.navigate(['/home/client-list']);
    }
  
  }
  
