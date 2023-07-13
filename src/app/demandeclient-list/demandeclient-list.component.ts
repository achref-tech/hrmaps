import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import Swal from 'sweetalert2';
import { DomSanitizer } from '@angular/platform-browser';
import { DemandeclientService } from '../demandeclient.service';
import { Router } from '@angular/router';
import { DemandeClientType } from '../demande-client-type';
import { Membre } from '../Models/Membre';
import { Commentaire } from '../Models/Commentaire';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { CommentsComponent } from '../comments/comments.component';
import { CommentService } from '../service/comment.service';
import { ElementRef,ViewChild } from '@angular/core';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';


@Component({
  selector: 'app-demandeclient-list',
  templateUrl: './demandeclient-list.component.html',
  styleUrls: ['./demandeclient-list.component.css']
})
export class DemandeclientListComponent implements OnInit {
  displayedColumns = [

    'demandeClientTypeId',
    'demandeclientTypeNom',
    'demandeclientTypePrenom',
    'demandeclientTypeVersion',
    'demandeclientDateFinDemande',
    'demandeclientDateDebutDemande',
    'etat',
    'membreId',
    'employeeId',
    'note',
    'commentaires'
    
  ];
  dataSource = new MatTableDataSource();
  public typeDemandeclients:DemandeClientType[];
  public employees:Employee[];
  public membres:Membre[];
  public images: any = [];
  employee: Employee = new Employee();
  demandeClientTypeId:number;
  //membreId:number;
  comment: string;
  selectedDemandeClientId: number | null;
  commentaires: Commentaire[];
  commentaire: Commentaire = new Commentaire();
  commenter: string;
  dialogRef: MatDialogRef<CommentsComponent>;
  votedEmployees: number[] = [];

  @ViewChild('buttonRef', { read: ElementRef }) buttonRef: ElementRef;
  //typedemandeClient: DemandeClientType = new DemandeClientType();
  constructor(private typedemandeclientservice:DemandeclientService,
    private router:Router,private service:EmployeeService,private commentService: CommentService,private dialog: MatDialog,private  _sanitizer: DomSanitizer,private dg : MatDialog) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData(){
    this.commentService.cancelComment$.subscribe(() => {
      this.cancelComment();
    });
    this.typedemandeclientservice.getDemandeClient().subscribe(
      (response:DemandeClientType[]) => {

        this.typeDemandeclients=response;
        console.log(this.typeDemandeclients)
        console.log(this.typeDemandeclients[0]?.demandeClientTypeId)
      },error => {
        console.log(error);
      }

    );
  }
  
  convert(base64String) {
    return this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64String)
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
/*  affecterClientAccepte(): void {
  
    if (this.typedemandeClient) {
    this.typedemandeclientservice.affecterclientAccepte(this.typedemandeClient).subscribe(data => {
      
         },error=>console.log(error));
      
    
  } else {
    console.log('typedemandeClient is undefined or null');
  }
  

}*/
likeButtonClick(demandeClientTypeId : number) {
  console.log('demandeClientTypeId:', demandeClientTypeId); // Check the value
  this.typedemandeclientservice.like(demandeClientTypeId).subscribe(() => {
    this.reloadData();
  });
}
/*likeButtonClick(demandeClientTypeId: number) {
  // ...

  const selectedTypeDemandeClient = this.typeDemandeclients.find(
    (typeDemandeClient) => typeDemandeClient.demandeClientTypeId === demandeClientTypeId
  );

  if (selectedTypeDemandeClient && !this.hasVoted(this.employee.employeeId, demandeClientTypeId)) {
    // ...

    // ...

    // Router vers l'interface des employees votants
    this.router.navigate(['/vote-employee', demandeClientTypeId]);
  }
}*/
/*hasVoted(employeeId: number, demandeClientTypeId: number): boolean {
  // Implement your logic to check if the employee has voted for the demandeClientTypeId
  // Return true if the employee has voted, false otherwise
  // For example, you can check a list of voted employees or query a database to determine the voting status
  // You can modify this code based on your actual implementation
  return this.votedEmployees.includes(employeeId);
}*/

dislikeButtonClick(demandeClientTypeId : number) {
  this.typedemandeclientservice.dislike(demandeClientTypeId).subscribe(()=>{
    this.reloadData();
  })
}
openComments(commentaires : any, demandeClientTypeId : number){
  this.dialog.open(CommentsComponent,{
    width: '400px',
    data:{
      commentaires:commentaires,
      demandeClientTypeId:demandeClientTypeId
    },
    panelClass: 'comments-dialog'
  
  }).afterClosed().subscribe(()=>{
    this.reloadData();
  })


  
}

affecterClientdemande(demandeClientTypeId: number ) {
  this.router.navigate(['/add-client', demandeClientTypeId]);
}  
/*TypeClient() {
  //this.typedemandeclientservice.createTypeDemandeClient(d).subscribe(
    (data :any)=> {
      const demandeClientTypeId = data.demandeClientTypeId;
      console.log("response received");
    this.router.navigate(['/add-client'], { queryParams: { demandeClientTypeId: demandeClientTypeId } });
    },
   error => {
    console.log("exception occured")
   }
  );
  }*/

  accepte(demandeClientTypeId: number) {
    console.log("demandeClientTypeId", demandeClientTypeId);
  this.typedemandeclientservice.affecterclientAccepte(demandeClientTypeId).subscribe(data => {
      this.go();
    },error=>console.log(error));
      // Succès de la mise à jour de l'état
      // Vous pouvez effectuer des actions supplémentaires si nécessaire
    
  }
  refuse(demandeClientTypeId: number) {
    console.log("demandeClientTypeId", demandeClientTypeId);
  this.typedemandeclientservice.affecterclientRefuse(demandeClientTypeId).subscribe(data => {
      this.go();
    },error=>console.log(error));
      // Succès de la mise à jour de l'état
      // Vous pouvez effectuer des actions supplémentaires si nécessaire
    
  }
  
go(){
  this.router.navigate(['/home/demandeclient-list']);

}
cancelComment() {
  this.router.navigate(['/home/demandeclient-list']);
}
toggleComments(TypeDemandeClient: any) {
  TypeDemandeClient.showComments = !TypeDemandeClient.showComments;
}
opensweetalert(demandeClientTypeId: number) {
  Swal.fire({
    title: 'Êtes-vous sûr de vouloir supprimer ce type de demande ?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#dc3545',
    cancelButtonColor: '#888888',
    cancelButtonText: 'Annuler',
    confirmButtonText: 'Oui, Supprimer!',
  }).then((result) => {
    if (result.isConfirmed) {
      this.deleteTypedemandeClient(demandeClientTypeId);
    }
  });
}
deleteTypedemandeClient(demandeClientTypeId: number) {
  this.typedemandeclientservice
    .deleteDemandeClientWithComments(demandeClientTypeId)
    .subscribe(
     /* (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );*/
    () => {
      Swal.fire({
        title: 'Supprimé!',
        text: 'Le type de demande et les commentaires associés ont été supprimés.',
        icon: 'success',
        confirmButtonText: 'OK'
      });
      this.reloadData();
    },
    (error) => {
      Swal.fire({
        title: 'Erreur!',
        text: 'Une erreur est survenue lors de la suppression du type de demande et des commentaires associés.',
        icon: 'error',
        confirmButtonText: 'OK'
      });
      console.log(error);
    }
  );
}
affecteremployeedemande(demandeClientTypeId: number){
  this.router.navigate(['/affecter-employee', demandeClientTypeId]);

}
}