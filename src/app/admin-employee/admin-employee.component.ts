import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-admin-employee',
  templateUrl: './admin-employee.component.html',
  styleUrls: ['./admin-employee.component.css']
})
export class AdminEmployeeComponent implements OnInit {
  employeeId:number;
  displayedColumns = [
    'employeeId',
    'employeeNom',
    'employeeAdresseMail',
    
  ];
  dataSource = new MatTableDataSource();
  employee: Employee[]=[];

  constructor(private employeeService:EmployeeService,
    private router:Router,
    private route:ActivatedRoute) { }

    @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

 

  ngOnInit(): void {
    this.employeeId = this.route.snapshot.params['employeeId']
    
    this.reloadData();
  }
  reloadData() {
    
    this.employeeService.getEmployeeList().subscribe((data) => {
      this.dataSource.data=data;
      console.log(data);
      console.log(this.dataSource.data);
    })
  }

}
