import { Version } from '@angular/compiler';
import { Component, OnInit,ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { VersionserviceService } from '../versionservice.service';
import { ActivatedRoute, Router } from '@angular/router';




@Component({
  selector: 'app-version-demande-list',
  templateUrl: './version-demande-list.component.html',
  styleUrls: ['./version-demande-list.component.css']
})
export class VersionDemandeListComponent implements OnInit {
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
