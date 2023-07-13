import { Version } from "./Version";
import { ClientType } from "./ClientType";
import { Etat } from "./Etat";
import { UploadImageClient } from "./UploadImageClient";


export class Client{
    clientId!: number;
    clientVolonte!: number;
	clientDescription!:string;
	clientDateDebutDemande!:Date;
	clientDateFinDemande!:Date;
	etat!:Etat;
    version!:Version;

	clientTypeId!:string;
	
	clientType!:ClientType;


    image:UploadImageClient;
    

}