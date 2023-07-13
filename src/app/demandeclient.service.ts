import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { DemandeClientType } from './demande-client-type';
import { Employee } from './Models/Employee';

@Injectable({
  providedIn: 'root'
})
export class DemandeclientService {
  private baseUrl:string = "http://localhost:8089/SpringMVC/demandeclient"

  constructor(private http: HttpClient) { }

  getDemandeClient(): Observable<DemandeClientType[]> {
    return this.http.get<DemandeClientType[]>(`${this.baseUrl}/retrieve-all-demandeclient/`);
  }
  deleteDemandeClientWithComments(demandeClientTypeId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${demandeClientTypeId}`, { responseType: 'text' });
  }
  /*updateDemandeClient(demandeClientTypeId: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/put/${demandeClientTypeId}`, { responseType: 'text' });
  }*/
  updateTypeDemandeClient(typeDemandeClient: DemandeClientType): Observable<DemandeClientType> {
    const url = `${this.baseUrl}/put/${typeDemandeClient.demandeClientTypeId}`;
    return this.http.put<DemandeClientType>(url, typeDemandeClient);
  }
 
  createTypeDemandeClient(fd:FormData,membreId:number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/add/${membreId}`, fd);
  }
  getTypeClient(demandeClientTypeId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/find/${demandeClientTypeId}`);
  }
  affecterclientAccepte(demandeClientTypeId:number): Observable<any> {
    return this.http.put<DemandeClientType>(`${this.baseUrl}/accepte/${demandeClientTypeId}`,null); 
  }
  affecterclientRefuse(demandeClientTypeId:number): Observable<any> {
    return this.http.put<DemandeClientType>(`${this.baseUrl}/refuse/${demandeClientTypeId}`,null); 
  }
  like(demandeClientTypeId : Number) : Observable<any>{
    return this.http.put("http://localhost:8089/SpringMVC/demandeclient/like-pub/"+demandeClientTypeId,null)
  }

  dislike(demandeClientTypeId : Number) : Observable<any>{
    return this.http.put("http://localhost:8089/SpringMVC/demandeclient/dislike-pub/"+demandeClientTypeId,null)
  }
  getComments(demandeClientTypeId : number) : Observable<any>{
    return this.http.get("http://localhost:8089/SpringMVC/demandeclient/get-comments/"+demandeClientTypeId);
  }
  comment(employeeId : Number , demandeClientTypeId : Number, comment : any) :Observable<any> {
    return this.http.post("http://localhost:8089/SpringMVC/demandeclient/add-comment-properly/"+employeeId+"/"+demandeClientTypeId,comment)
  }
  updatecomment( data:any): Observable<any> {
    return this.http.put<DemandeClientType[]>("http://localhost:8089/SpringMVC/demandeclient/put", data);
  }
  getDemandeClientTypeByMembreId(membreId: number): Observable<DemandeClientType[]> {
    return this.http.get<DemandeClientType[]>(`${this.baseUrl}/membre/${membreId}`);
  }
  affecteremployeedemande(employeeId:number,data:DemandeClientType): Observable<any> {
    return this.http.put<DemandeClientType>(`${this.baseUrl}/employeee/${employeeId}`,data); 
  }
  



}
