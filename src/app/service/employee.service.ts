import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../Models/Employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public employee: Employee;

  private baseUrl:string = "http://localhost:8089/SpringMVC/employee"

  constructor(private http: HttpClient) { }

  getEmployee(employeeId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/employee/${employeeId}`);
  }
  public  loginEmployee(employee:Employee) : Observable<any> {
   return this.http.post<any>("http://localhost:8089/SpringMVC/employee/loginn",employee);
  }

  public registreEmployee(employee:Employee) : Observable<any>{
    return this.http.post<any>("http://localhost:8089/SpringMVC/employee/registreEmployee",employee);
   }
   getEmployeeList(): Observable<Employee[]> {
    return this.http.get<Employee[]>("http://localhost:8089/SpringMVC/employee/employees");

  }
 /* getVotedEmployees(demandeClientTypeId: number): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.baseUrl}/votedEmployees/${demandeClientTypeId}`);
  }*/
  getVotedEmployees(demandeClientTypeId: number): Observable<Employee[]> {
    const url = `${this.baseUrl}/votedEmployees/${demandeClientTypeId}`; // Assurez-vous que l'URL de l'API est correcte

    return this.http.get<Employee[]>(url);
  }
}
