import { Component, OnInit,ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Version } from '@angular/compiler';
import { VersionserviceService } from '../versionservice.service';
@Component({
  selector: 'app-employee-versionlist',
  templateUrl: './employee-versionlist.component.html',
  styleUrls: ['./employee-versionlist.component.css']
})
export class EmployeeVersionlistComponent implements OnInit {

  versionId:number;
  
  displayedColumns = [
  
  'versionId',
	
	'versionEmplacement',
	'versionLibelle',
  'versionEmailResponsable',
	'versionResponsable',
	
  ];
  dataSource = new MatTableDataSource();
  version: Version[]=[];

  constructor(private versionService:VersionserviceService,
    private router:Router,
    private route:ActivatedRoute) { }
    @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit(): void {
    this.versionId = this.route.snapshot.params['versionId']
    
    this.reloadData();
  }
  reloadData(){
    this.versionService.getVersion().subscribe((data) => {
      this.dataSource.data=data;
      console.log(data);
      console.log(this.dataSource.data);
    })
  
  }

}
