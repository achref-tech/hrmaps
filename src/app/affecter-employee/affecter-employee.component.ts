import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { DemandeclientService } from '../demandeclient.service';
import { DemandeClientType } from '../demande-client-type';

@Component({
  selector: 'app-affecter-employee',
  templateUrl: './affecter-employee.component.html',
  styleUrls: ['./affecter-employee.component.css']
})
export class AffecterEmployeeComponent implements OnInit {
  employeeId:number;
  typeDemandeclient:DemandeClientType;
  displayedColumns = [
    'employeeId',
    'employeeNom',
    'employeeAdresseMail',
    'operations',
    
  ];
  dataSource = new MatTableDataSource();
  employee: Employee[]=[];

  constructor(private employeeService:EmployeeService,private service:DemandeclientService,
    private router:Router,
    private route:ActivatedRoute) { }
    @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  ngAfterViewInit() {
    //this.dataSource.paginator = this.paginator;
    //this.dataSource.sort = this.sort;
  }

  getDemandeClientType(demandeClientTypeId: number) {
    // console.log("ID : "+id)
    this.typeDemandeclient = new DemandeClientType;
    this.service.getTypeClient(demandeClientTypeId).subscribe(res => {
      this.typeDemandeclient.demandeClientTypeId = res.demandeClientTypeId
      this.typeDemandeclient.demandeclientDateDebutDemande = res.demandeclientDateDebutDemande
      this.typeDemandeclient.demandeclientDateFinDemande = res.demandeclientDateFinDemande
      this.typeDemandeclient.demandeclientTypeNom = res.demandeclientTypeNom
      this.typeDemandeclient.demandeclientTypePrenom = res.demandeclientTypePrenom
      this.typeDemandeclient.demandeclientTypeVersion = res.demandeclientTypeVersion
       this.typeDemandeclient.etat = res.etat
       this.typeDemandeclient.membreId = res.membreId
       this.typeDemandeclient.employeeId = res.employeeId
       this.typeDemandeclient.note = res.note
       this.typeDemandeclient.commentaires = res.commentaires
       this.typeDemandeclient.image=res.image


      

      console.log(this.typeDemandeclient)




      // console.log(this.reunion)
    })
  }
  ngOnInit(): void {
    this.getDemandeClientType(this.route.snapshot.params['demandeClientTypeId'])
    
    this.reloadData();
    console.log(this.typeDemandeclient)

  }
  reloadData() {
    
    this.employeeService.getEmployeeList().subscribe((data) => {
      this.dataSource.data=data;
      console.log(data);
      console.log(this.dataSource.data);
    })
  }
  affecteremployeedemande(employeeId: number): void {
  
    console.log("employee ", employeeId);

    this.service.affecteremployeedemande(employeeId, this.typeDemandeclient).subscribe(data => {
      
         this.gotoList();
         },error=>console.log(error));
      
    
  }





  gotoList() {
    this.router.navigate(['/home/demandeclient-list']);
  }

}
