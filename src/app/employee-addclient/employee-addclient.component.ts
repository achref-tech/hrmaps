import { Component, OnInit } from '@angular/core';
import { Client } from '../Models/Client';
import { TypeClientService } from '../services/type-client.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Version } from '../Models/Version';
import { MatTableDataSource } from '@angular/material/table';
import { DemandeClientType } from '../demande-client-type';
import { DemandeclientService } from '../demandeclient.service';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-employee-addclient',
  templateUrl: './employee-addclient.component.html',
  styleUrls: ['./employee-addclient.component.css']
})
export class EmployeeAddclientComponent implements OnInit {

  displayedColumns = [

    'clientId',
    'clientVolonte', 
    'clientDescription',
    'clientDateDebutDemande',
    'clientDateFinDemande',
    'etat',
    'version',
    'operations',
  ];
  
  constructor(private clientService : TypeClientService , private router : Router,private route : ActivatedRoute) { }
  dataSource = new MatTableDataSource();
  client : Client = new Client () ;
  Version : Version = new Version();
  selectedFile!: File
  imagePreview: any;
  form: FormGroup;
  formData: FormData;
  demandeclientTypeId:number;
  demandeClientType:DemandeClientType;
  
  ngOnInit(): void {
    
    this.form = new FormGroup({
      // note: new FormControl('', [Validators.required]),
      
      image: new FormControl('', [Validators.required]),
      clientDateDebutDemande: new FormControl('', [Validators.required]),
      clientVolonte: new FormControl('', [Validators.required]),
      clientDateFinDemande : new FormControl('', [Validators.required]),
      clientDescription: new FormControl('', [Validators.required]),



    })
  }
  goTOClientlist() {
    this.router.navigate(['/employee-listclient']);

  }
  addClientType(): void {
    this.formData = new FormData();
    if (this.form.valid) {
    
      this.formData.append('clientVolonte', this.form.value.clientVolonte)
    this.formData.append('clientDescription', this.form.value.clientDescription),
    this.formData.append('clientDateDebutDemande', this.form.value.clientDateDebutDemande),
    this.formData.append('clientDateFinDemande', this.form.value.clientDateFinDemande),
    this.formData.append('image', this.selectedFile, this.selectedFile.name);
 
    
    this.clientService.createTypeClient(this.formData).subscribe(() => {
    this.goTOClientlist();
    });
    
  }
}
  onFileUpload(event){
    console.log(event.target.files)
    this.selectedFile = event.target.files[0];
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
    reader.readAsDataURL(this.selectedFile);

  }
    // this.publicationService.createPublication(this.publication, this.iduser).subscribe(data => {
    //   console.log(data);
    //   this.goToPublicationlist();
    // },
    //   error => console.log(error));

    onSubmit() {
      console.log(this.client);
      this.addClientType();
    }
    
  
  }




