import { Component, OnInit,ViewChild} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { TypeClientService } from '../services/type-client.service';
import { Client } from '../Models/Client';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import Swal from 'sweetalert2';
import { Version } from '../Models/Version';
import { DomSanitizer } from '@angular/platform-browser';
import { MatDialog } from '@angular/material/dialog';
import { error } from 'console';
import { Employee } from '../Models/Employee';
@Component({
  selector: 'app-employee-listclient',
  templateUrl: './employee-listclient.component.html',
  styleUrls: ['./employee-listclient.component.css']
})
export class EmployeeListclientComponent implements OnInit {

  displayedColumns = [

    'clientId',
    'clientVolonte', 
    'clientDescription',
    'clientDateDebutDemande',
    'clientDateFinDemande',
    'etat',
    'version',
    
    'operations',
  ];
  dataSource = new MatTableDataSource();
  public clients: Client[]; 
  
  
  public images: any = [];
  versionmax: string;
  clientId:number;
  url :string ="assets/src/images"
  //imageURL : string = "Desktop\hrmaps\hrmaps\src\assets\src\images\202.jpg";
  
   


  constructor(private clientservice: TypeClientService,
    private router: Router,private _sanitizer: DomSanitizer) { }
    //@ViewChild(MatPaginator) paginator!: MatPaginator;
    //@ViewChild(MatSort) sort!: MatSort;
    ngAfterViewInit() {
      //this.dataSource.paginator = this.paginator;
      //this.dataSource.sort = this.sort;
    }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    //this.clientservice.file().subscribe(response=> {
      //this.images=response;
    //})
    this.clientservice.getTypeClientList().subscribe(
      (response:Client[]) => {

      this.clients = response;
      console.log(this.clients)
      },
      

    );
  }
    
  public searchClient(key:string) : void{
    console.log(key);
    const results : Client[]=[];
    for (const client of this.clients) {
      if (client.clientDescription.toLowerCase().indexOf(key.toLowerCase())!== -1
      
      ) {
        results.push(client);
      }
    }
    this.clients = results;
    if (results.length ==0 || !key) {
      this.reloadData();
    }
    }
  
     
    
   // this.clientservice.file().subscribe(response=> {
     // this.images=response;
    //})
  
  convert(base64String) {
    return this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64String)
  }
  deleteTypeClient(clientId: number) {
    this.clientservice
      .deleteTypeClient(clientId)
      .subscribe(
        (data) => {
          console.log(data);
          this.reloadData();
        },
        (error) => console.log(error)
      );
  }
  TypeClientDetails(clientId: number) {
    this.router.navigate(['/home/client-list/client-details',clientId]);
  }
  

  updateTypeClient(clientId: number) {
    this.router.navigate(['/employee-listclient/employee-updateclient', clientId]);
  }
  affecterClientVersion(clientId: number ) {
    this.router.navigate(['/employee-listclient/employee-affecterclient', clientId]);
  }
  clientDetails(clientId: number) {
    this.router.navigate(['/employee-listclient/employee-detailsclient', clientId]);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  opensweetalert(clientId: number) {
    Swal.fire({
      title: 'Êtes-vous sûr de vouloir supprimer ce type de participant ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#dc3545',
      cancelButtonColor: '#888888',
      cancelButtonText: 'Annuler',
      confirmButtonText: 'Oui, Supprimer!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.deleteTypeClient(clientId);
      }
    });
  }

}

