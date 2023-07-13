import { Component, OnInit } from '@angular/core';
import { DemandeclientService } from '../demandeclient.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup,FormControl,Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { DemandeClientType } from '../demande-client-type';
import { Membre } from '../Models/Membre';
import { MembreService } from '../membre.service';


@Component({
  selector: 'app-add-demandeclient',
  templateUrl: './add-demandeclient.component.html',
  styleUrls: ['./add-demandeclient.component.css']
})
export class AddDemandeclientComponent implements OnInit {
  displayedColumns = [

    'demandeclientTypeId',
    'demandeclientTypeLibelle', 
    'demandeclientTypeDescription',
    'demandeclientTypeNom',
    'demandeclientTypePrenom',
    'demandeclientTypeVersion',
    'demandeclientDateFinDemande',
    'demandeclientDateDebutDemande',
    'etat',
    'membreId',
    
  ];

  



  constructor(private service:MembreService,private demandeclientService : DemandeclientService , private router : Router,private route : ActivatedRoute) { }
  demandeclientType:DemandeClientType=new DemandeClientType();
  form: FormGroup;
  submitted = false;
  demandeclientTypeId:number;
  membre: Membre = new Membre();
  //membreAdresseMail:string="";

  membreId:number;
  formData: FormData;
  dataSource = new MatTableDataSource();
  selectedFile!: File
  imagePreview: any;
  msg ='';
 
  

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.membreId = +params['membreId'] || 0;
    
    this.service.getMembre(this.membreId).subscribe((data:Membre) => {
      
      this.membre = data;
      console.log(this.membre);

      
    }, error=>console.log(error));
  })

    this.form = new FormGroup({
      // note: new FormControl('', [Validators.required]),
      
      image: new FormControl('', [Validators.required]),
      demandeclientDateDebutDemande: new FormControl('', [Validators.required]),
      demandeclientDateFinDemande: new FormControl('',[Validators.required]),
      demandeclientTypeNom: new FormControl('', [Validators.required]),
      demandeclientTypePrenom: new FormControl('', [Validators.required]),

      demandeclientTypeVersion: new FormControl('', [Validators.required]),




    })
  }
  goTOClientDemandelist() {
    //this.router.navigate(['/demande-sucess']);
    this.router.navigate(['/demande-sucess'], { queryParams: { membreId: this.membreId } });

  }
  adddemandeclientType() :void {
    this.formData = new FormData();
    
      if (this.form.valid) {
    
        this.formData.append('demandeclientTypeNom', this.form.value.demandeclientTypeNom),
  
      this.formData.append('demandeclientTypePrenom', this.form.value.demandeclientTypePrenom),
      this.formData.append('demandeclientTypeVersion', this.form.value.demandeclientTypeVersion),
  
      this.formData.append('demandeclientDateDebutDemande', this.form.value.demandeclientDateDebutDemande),
      this.formData.append('demandeclientDateFinDemande', this.form.value.demandeclientDateFinDemande),
      this.formData.append('image', this.selectedFile, this.selectedFile.name);
      this.formData.append('membreId',this.form.value.membreId);
    
 
    
    this.demandeclientService.createTypeDemandeClient(this.formData,this.membreId).subscribe(() => {
    this.goTOClientDemandelist();
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
 
  onSubmit() {
    console.log(this.demandeclientType);
    this.adddemandeclientType();
    
  }
  

  

}
