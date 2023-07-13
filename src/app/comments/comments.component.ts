import { Component, Inject,  OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DemandeclientService } from '../demandeclient.service';
import { CommentService } from '../service/comment.service';
import { Employee } from '../Models/Employee';
import { EmployeeService } from '../service/employee.service';
import { Observable, catchError, map, of } from 'rxjs';
import { Commentaire } from '../Models/Commentaire';


@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
   commentaires: any[];
  
  //commentaires: Map<number, Comment[]> = new Map<number, Comment[]>();
  //commentaires: { [demandeClientTypeId: number]: Comment[] } = {};
  employee: Employee = new Employee();
  employeeId:number;
  employeeNom: string="";
  //comments: Comment[] = [];
  



  constructor(
    @Inject(MAT_DIALOG_DATA)private data : any,
    private commentService: CommentService,
    private service : DemandeclientService,

    private thisDg : MatDialogRef<CommentsComponent>,private employeeService: EmployeeService
  ) {
    
    
      this.commentaires = data.comment;
      this.employeeId = data.employeeId;
      this.employeeNom = data.employeeNom;
  
  }
  
  


  form! : FormGroup;

  comments ! : any
  demandeClientTypeId ! : any
  commentId: number

  ngOnInit(): void {
  console.log(this.employeeId); // Vérifiez si l'employeeId est correctement assigné
    //console.log(this.employeeId);
    this.employeeId = this.data['employeeId'];
    this.employeeService.getEmployee(this.employeeId).subscribe(employee => {
      this.employee= employee;
    });

    this.demandeClientTypeId = this.data['demandeClientTypeId']
    this.service.getComments(this.demandeClientTypeId).subscribe(res=>{
      this.comments = res;
      console.log(this.comments); // Vérifiez si les commentaires sont correctement récupérés de la base de données
      
    })
    this.form = new FormGroup({
      commentaire : new FormControl('',Validators.required)
    })

  }
  getEmployeeName(employeeId: number):  Observable<string> {
    const employee = this.comments.find(comment => comment.employeeId === employeeId);
    return employee ? of(employee.employeeNom):of('') ;
  }

  postComment(){
    
    let comment : Comment = new Comment();
    comment.comment = this.form.value.commentaire
    comment.demandeClientTypeId = this.demandeClientTypeId;
    comment.employee = new Employee();
    comment.employee.employeeId=this.employee.employeeId;
    this.service.comment(this.employeeId,this.demandeClientTypeId,comment).subscribe(()=>{
      this.thisDg.close();
    })
  
    
    /*const comment: Comment = new Comment();
    comment.comment = this.form.value.commentaire;
    comment.demandeClientTypeId = this.demandeClientTypeId;
  
    const comments: Comment[] = [comment]; // Crée un tableau avec un seul commentaire
  
    this.service.comment(this.employeeId, this.demandeClientTypeId, [comment]).subscribe(() => {
      this.thisDg.close();
    });*/
    // Vérifier si un commentaire existe déjà pour le demandeClientTypeId
    
      
   
    // Vérifier si un commentaire existe déjà pour le demandeClientTypeId
    
    /*const comment: Comment = new Comment();
  comment.comment = this.form.value.commentaire;
  this.service.getTypeClient(this.demandeClientTypeId).subscribe(existingComment => {
      if (existingComment) {
        // Mettre à jour le commentaire existant avec le nouveau contenu
        existingComment.comment = newComment.comment;
        this.service.(existingComment).subscribe(() => {
          this.employeeId = this.employeeId;
  comment.demandeClientTypeId = this.demandeClientTypeId;

  if (!(this.demandeClientTypeId in this.commentaires)) {
    this.commentaires[this.demandeClientTypeId] = [];
  }

  this.commentaires[this.demandeClientTypeId].push(comment);

  this.service.comment(this.employeeId, this.demandeClientTypeId, comment).subscribe(() => {
    this.thisDg.close();
  });*/
  }
  cancelComment() {
    this.commentService.cancelComment();
    this.thisDg.close();
  }

  deleteComment( idComm:number) {
    // Vérifier si l'employé actuel correspond à l'employé associé au commentaire
    const comment = this.comments.find(c => c. idComm ===  idComm);
    
    console.log( idComm)
    if (comment && comment.employeeId.employeeId === this.employeeId||this.employeeId === null || this.employeeId === undefined) {
      this.commentService.deletecomment( idComm).subscribe(() => {
        // Suppression réussie
        // Vous pouvez mettre à jour la liste des commentaires ici ou effectuer d'autres actions nécessaires
      }, error => {
        // Gérer les erreurs de suppression du commentaire
        console.log(error);
      });
    } else {
      // L'employé actuel n'est pas autorisé à supprimer ce commentaire
      console.log('Vous n\'êtes pas autorisé à supprimer ce commentaire');
    }
    
  }
  isDeleteAllowed(comment: any): boolean {
    if (comment && comment.employeeId.employeeId === this.employeeId||this.employeeId === null || this.employeeId === undefined) {
      // L'administrateur est autorisé à supprimer tous les commentaires
      return true;
    } else {
      // Vérifier si l'employé actuel correspond à l'employé associé au commentaire
      return comment.employeeId === this.employeeId;
    }
  }



}

export class Comment{
  comment : string
  //employeeId:number
  employee: Employee
  demandeClientTypeId:number
  
}

  
