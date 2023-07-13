import { Component, OnInit } from '@angular/core';
import { Commentaire } from '../Models/Commentaire';
import { DemandeClientType } from '../demande-client-type';
import { Employee } from '../Models/Employee';
import { CommentaireService } from '../service/commentaire.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-commentaire',
  templateUrl: './create-commentaire.component.html',
  styleUrls: ['./create-commentaire.component.css']
})
export class CreateCommentaireComponent implements OnInit {

  commentaire:Commentaire = new Commentaire();
  demandeClientTypeId:number;
  employeeId:number;
  demandeClientType:DemandeClientType = new DemandeClientType();
  employee:Employee=new Employee();

  constructor(private commentaireService:CommentaireService
    ,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.demandeClientTypeId=this.route.snapshot.params['demandeClientTypeId'];
    this.employeeId=this.route.snapshot.params['employeeId'];
    this.commentaireService.getTypeClient(this.demandeClientTypeId).subscribe(data => {
      this.demandeClientType=data;
    },error => console.log(error));
    
  }
  savecommentaire() {
    this.commentaireService.createCommentaire(this.commentaire,this.employeeId,this.demandeClientTypeId).subscribe(data => {
    console.log(data);
    this.list();
    },
    error => console.log(error));
    }
    list() {
      this.router.navigate(['/demandeclient-list']);


    }
    onSubmit() {
      console.log(this.commentaire);
    this.savecommentaire();
    
}
  

}
