import { Component, OnInit ,ElementRef} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import Swal from 'sweetalert2';
import { DomSanitizer } from '@angular/platform-browser';
import { DemandeclientService } from '../demandeclient.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DemandeClientType } from '../demande-client-type';
import { Commentaire } from '../Models/Commentaire';
import { MatDialog } from '@angular/material/dialog';
import { CommentsComponent } from '../comments/comments.component';
import { CommentService } from '../service/comment.service';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';
import { Membre } from '../Models/Membre';

@Component({
  selector: 'app-employee-listdemandeclient',
  templateUrl: './employee-listdemandeclient.component.html',
  styleUrls: ['./employee-listdemandeclient.component.css']
})
export class EmployeeListdemandeclientComponent implements OnInit {

  displayedColumns = [

    'demandeclientTypeId',
    
    'demandeclientTypeNom',
    'demandeclientTypePrenom',
    'demandeclientTypeVersion',
    'demandeclientDateFinDemande',
    'demandeclientDateDebutDemande',
    'etat',
    'membreId',
    'employeeId',
    
  ];
  dataSource = new MatTableDataSource();
  public TypeDemandeclients:DemandeClientType[];
  public employees:Employee[];

  public membres:Membre[];
  public images: any = [];
  demandeClientTypeId:number;
  typedemandeClient: DemandeClientType = new DemandeClientType();
  comment: string;
  selectedDemandeClientId: number;
  commentaires: Commentaire[];
  commentaire: Commentaire = new Commentaire();
  commenter: string;
  employee: Employee = new Employee();
  employeeId:number;
  employeeNom: string="";
  votedEmployees: number[] = [];
  public showComments: boolean;
  //votedEmployees: Set<number> = new Set<number>();


  constructor(private elementRef: ElementRef,private service:EmployeeService,private commentService: CommentService,private dialog: MatDialog,private typedemandeclientservice:DemandeclientService,
    private router:Router,private  _sanitizer: DomSanitizer,private route : ActivatedRoute) {
    }
    

  ngOnInit(): void {
    const votedDemandes = Object.keys(localStorage)
    .filter((key) => key.startsWith(`votedDemande_${this.employeeId}`))
    .map((key) => parseInt(key.split('_')[2]));

  votedDemandes.forEach((demandeClientTypeId: number) => {
    this.disableVotingForDemande(demandeClientTypeId); // Disable voting for the demandeClientTypeId if already voted
  });
   
    this.route.queryParams.subscribe(params => {
      this.employeeId = +params['employeeId'] || 0;
      console.log(this.employeeId)
    
    this.service.getEmployee(this.employeeId).subscribe((data:Employee) => {
      
      this.employee = data;
     console.log(this.employee);
      
    }, error=>console.log(error));
  });
  this.loadEmployees();
  
  /*const employeeIdParam = this.route.snapshot.params['id'];
  console.log('Employee ID param:', employeeIdParam);
  this.employeeId = parseInt(employeeIdParam, 10);
  //this.route.params.subscribe(params => {
//this.employeeId =+this.route.snapshot.params['id'];
if (isNaN(this.employeeId)) {
  console.log('Invalid employee ID');
  // Handle the error or redirect to an error page
} else {
  this.service.getEmployee(this.employeeId).subscribe(
    (response) => {
      this.employee = response;
      console.log(this.employee);
    },
    (error) => {
      console.log(error);
    }
  );
  
  }

  
*/
    this.reloadData();
}
  
  loadEmployees() {
    this.service.getEmployee(this.employeeId).subscribe(
      (data: Employee[]) => {
        this.employees = data;
      },
      error => console.log(error)
    );
  }
  reloadData(){
    this.commentService.cancelComment$.subscribe(() => {
      this.cancelComment();
    });
    this.typedemandeclientservice.getDemandeClient().subscribe(
      (response:DemandeClientType[]) => {

        this.TypeDemandeclients=response;
        console.log(this.TypeDemandeclients)
        console.log(this.TypeDemandeclients[0]?.demandeClientTypeId)
      },error => {
        console.log(error);
      }
      

    );
  }
  openComments(commentaires: any, demandeClientTypeId: number) {
    this.selectedDemandeClientId = demandeClientTypeId;
    
    
    
    this.dialog.open(CommentsComponent, {
      width:'400px',
      data: {
        commentaires: commentaires,
        demandeClientTypeId: demandeClientTypeId,
        employeeId: this.employeeId,
        employeeNom: this.employee.employeeNom,
        
      },
      panelClass: 'comments-dialog',
      
      
    });
    
  }


  convert(base64String) {
    return this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + base64String)
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  /*affecterClientAccepte(): void {
  
    if (this.typedemandeClient) {
    this.typedemandeclientservice.affecterclientAccepte(this.typedemandeClient).subscribe(data => {
      
         },error=>console.log(error));
      
    
  } else {
    console.log('typedemandeClient is undefined or null');
  }
  

}*/
/*likeButtonClick(demandeClientTypeId : number) {
  console.log('demandeClientTypeId:', demandeClientTypeId); // Check the value
  const employeeId =this.employeeId;
  if(this.hasvote(employeeId)){
    return;
  }
  this.typedemandeclientservice.like(demandeClientTypeId).subscribe(() => {
    this.reloadData();
    this.addvoteemployee(employeeId);
  });
}
  hasvote(employeeId:number):boolean{
    return this.votedEmployees.includes(employeeId);
}
addvoteemployee(employeeId:number){
  this.votedEmployees.push(employeeId);
}*/





likeButtonClick(demandeClientTypeId: number) {
  console.log('demandeClientTypeId:', demandeClientTypeId); // Check the value

  // Find the TypeDemandeClient with the corresponding demandeClientTypeId
  const selectedTypeDemandeClient = this.TypeDemandeclients.find(
    (typeDemandeClient) => typeDemandeClient.demandeClientTypeId === demandeClientTypeId
  );
  if (selectedTypeDemandeClient &&!this.hasVoted(this.employeeId,demandeClientTypeId)) {
    selectedTypeDemandeClient.note += 1
    //this.votedEmployees.push(this.employeeId);
    localStorage.setItem(`votedDemande_${this.employeeId}_${demandeClientTypeId}`, 'true');


  // Update the note value to 1 if not already liked, or set it to 0 if already liked
  this.typedemandeclientservice.like(demandeClientTypeId).subscribe(() => {
    this.reloadData();
  });
}
}
hasVoted(employeeId: number, demandeClientTypeId: number): boolean {
  return localStorage.getItem(`votedDemande_${employeeId}_${demandeClientTypeId}`) === 'true';
}
disableVotingForDemande(demandeClientTypeId: number): void {
  // Logic to disable voting UI or provide feedback to the employee for a specific demandeClientTypeId
  // For example, you can disable the voting button or show a message that the employee has already voted for this demandeClientTypeId.
}


/*likeButtonClick(demandeClientTypeId: number) {
  console.log('demandeClientTypeId:', demandeClientTypeId); // Vérifiez la valeur

  // Vérifiez si l'employeeId a déjà voté
  if (!this.hasVoted(this.employee.employeeId)) {
    // Appel du service pour effectuer le vote
    this.typedemandeclientservice.like(demandeClientTypeId, this.employee).subscribe(
      () => {
        console.log('Vote soumis avec succès');
        // Effectuez d'autres actions si nécessaire
      },
      (error) => {
        console.error('Échec de la soumission du vote', error);
        // Gérez les erreurs qui se produisent lors de la soumission du vote
      }
    );
  }
}*/


dislikeButtonClick(demandeClientTypeId : number) {
  this.typedemandeclientservice.dislike(demandeClientTypeId).subscribe(()=>{
    this.reloadData();
  })
}


cancelComment() {
  this.router.navigate(['/employee-listDemandeclient']);
}
toggleComments(TypeDemandeClient: any) {
  TypeDemandeClient.showComments = !TypeDemandeClient.showComments;
}

}

