import { Component, OnInit } from '@angular/core';
import { MailServiceService } from '../mail-service.service';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-send-mail',
  templateUrl: './send-mail.component.html',
  styleUrls: ['./send-mail.component.css']
})
export class SendMailComponent implements OnInit {
  to: string;
  subject: string;
  text: string;
  constructor(public mail:MailServiceService){}
  sendEmail(): void {
    this.mail.sendEmail(this.to, this.subject, this.text).subscribe(
      response => {
        console.log('E-mail envoyé avec succès');
        // Réinitialisez les champs du formulaire après l'envoi
        this.to = '';
        this.subject = '';
        this.text = '';
      },
      error => {
        console.log('Erreur lors de l\'envoi de l\'e-mail:', error);
      }
    );
  }

  ngOnInit(): void {
    this.sendEmail()
    
  }

}
  /*num:any;
  code:string;
  submitted=false;
  constructor(public crudApi:MailServiceService,public fb:FormBuilder,private router:Router
    ,public dialogRef:MatDialogRef<SendMailComponent>) { }
    get f() {return this.crudApi.formData.controls}

  ngOnInit(): void {
    this.infoForm()
  }
  infoForm(){
    this.crudApi.formData=this.fb.group({
      id:null,
      destinataire:['',[Validators.required]],
      objet:['',[Validators.required]],
      message:['',[Validators.required]]
    });

  }
  ResetForm(){
    this.crudApi.formData.reset();
  }
  Lister() {
    this.router.navigate(['/mail-list'])
  }
  addData(){
    this.crudApi.createData(this.crudApi.formData.value).subscribe(data=>{
      this.dialogRef.close();
      this.crudApi.getAll().subscribe(
        response => {this.crudApi.getAll=response;}
      );
      this.router.navigate(['/mail-list']);
      });
   
  }
  onSubmit(){
    this.addData();
    alert("mail sucess");
  }
}
*/