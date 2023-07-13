import { DemandeClientType } from "../demande-client-type";
import { Employee } from "./Employee";

export class Commentaire{
    idComm!: number;
    comment!: String;
	employeeId!:Employee;
	demandeClientTypeId!:DemandeClientType;
    
}