import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Conge } from '../Models/Conge';


@Injectable({
  providedIn: 'root'
})
export class CongeService {
  private baseUrl:string = "http://localhost:8089/SpringMVC/conge"

  constructor(private http: HttpClient) { }

  getTypeConge(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/findconge/${id}`);
  }
  getAllConge(): Observable<Conge[]> {
    return this.http.get<Conge[]>(`${this.baseUrl}/listeconge/`);
  }
  createConge(conge:any,employeeId:number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/ajoutconge/${employeeId}`, conge);
  }
  affecterclientAccepte(id:number): Observable<any> {
    return this.http.put<Conge>(`${this.baseUrl}/accepte/${id}`,null); 
  }
  affecterclientRefuse(id:number): Observable<any> {
    return this.http.put<Conge>(`${this.baseUrl}/refuse/${id}`,null); 
  }
  getCongeByEmployeeId(employeeId: number): Observable<Conge[]> {
    return this.http.get<Conge[]>(`${this.baseUrl}/employee/${employeeId}`);
  }

}
