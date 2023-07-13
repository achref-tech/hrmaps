import { Commentaire } from "./Models/Commentaire";
import { Employee } from "./Models/Employee";
import { Etat } from "./Models/Etat";
import { Membre } from "./Models/Membre";
import { Vote } from "./Models/Vote";
import { DemandeClientComponent } from "./demande-client/demande-client.component";
import { UploadImageTypeClient } from "./upload-image-type-client";

export class DemandeClientType {
    demandeClientTypeId: number;
    demandeclientTypeLibelle!: string ;
    demandeclientTypeDescription!: string;
    demandeclientTypeNom!:string;
    demandeclientTypePrenom!:string;
    demandeclientTypeVersion!:number;
    demandeclientDateDebutDemande!:Date;
	  demandeclientDateFinDemande!:Date;
    image:UploadImageTypeClient;
    etat! : Etat
    vote:Vote;
    note: number;
    employeeId:Employee;
    membreId:Membre;
    commentaires:Commentaire;
  }
