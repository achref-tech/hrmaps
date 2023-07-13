import { DemandeClientType } from "../demande-client-type";
import { Employee } from "./Employee";

export class Vote {
    id:number;
    note:number;
    demandeclienttype:DemandeClientType;
    employee:Employee;
}