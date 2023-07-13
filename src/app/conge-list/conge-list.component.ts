import { Component, OnInit,AfterViewInit,ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Conge } from '../Models/Conge';
import { ActivatedRoute, Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { CongeService } from '../service/conge.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-conge-list',
  templateUrl: './conge-list.component.html',
  styleUrls: ['./conge-list.component.css']
})
export class CongeListComponent implements OnInit,AfterViewInit {
  displayedColumns = [
    'id',
    'name',
    'startDate',
    'endDate',
    'reason',
    'etat',
    'employeeId',
    'operations',
  ];
  dataSource = new MatTableDataSource();
  //dataSource: MatTableDataSource<any>;
  conge:Conge;
  id:number;

  constructor(private router: Router
    , private route: ActivatedRoute,private service:CongeService) { }
    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;
  
    ngAfterViewInit() {
      //this.dataSource.paginator = this.paginator;
      //this.dataSource.sort = this.sort;
    }
  

  ngOnInit(): void {
    //this.dataSource = new MatTableDataSource<any>
    this.reloadData()
  }
  reloadData(){
    this.service.getAllConge().subscribe((data) => {
      this.dataSource.data = data;
      console.log(data);
      console.log(this.dataSource.data);
      // console.log(this.dataSource.data);
    })
  }
  accepte(id: number) {
    console.log("id", id);
    Swal.fire({
      title: 'Êtes-vous sûr de vouloir accepter ce conge ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: 'green',
      cancelButtonColor: '#888888',
      cancelButtonText: 'Annuler',
      confirmButtonText: 'Oui, accepte',
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.affecterclientAccepte(id).subscribe(data => {
          this.go();
        },error=>console.log(error));
    }
  });
    
      // Succès de la mise à jour de l'état
      // Vous pouvez effectuer des actions supplémentaires si nécessaire
    
  }
  refuse(id: number) {
    console.log("id", id);
    Swal.fire({
      title: 'Êtes-vous sûr de vouloir refuser ce conge ?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#dc3545',
      cancelButtonColor: '#888888',
      cancelButtonText: 'Annuler',
      confirmButtonText: ' oui , refuse',
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.affecterclientRefuse(id).subscribe(data => {
          this.go();
        },error=>console.log(error));
    }
  });
  }
  go(){
    this.router.navigate(['/conge-list']);
  
  }
}
