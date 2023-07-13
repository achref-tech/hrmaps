import { Employee } from "./Employee";
import { Etat } from "./Etat";

export class Conge{
    id!: number;
    startDate!: Date;
	endDate!:Date;
	reason!:string;
    name!:string;
    etat! : Etat;
    employeeId:Employee;
}