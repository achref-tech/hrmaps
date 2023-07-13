import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Commentaire } from '../Models/Commentaire';

@Injectable({
  providedIn: 'root'
})
export class CommentaireService {
  private baseUR16:string = "http://localhost:8089/SpringMVC/add-comment";
  private baseUR17:string = "http://localhost:8089/SpringMVC/retrieve-all-comment/{demandeClientTypeId}/{employeeId}";
  private baseURl8:string = "http://localhost:8089/SpringMVC/demandeclient";

  constructor(private httpClient :HttpClient) { }

createCommentaire(commentaire:Commentaire,employeeId:number,demandeClientTypeId:number): Observable<object>{
    return this.httpClient.post(`${this.baseUR16}/${employeeId}/${demandeClientTypeId}`+commentaire+employeeId,demandeClientTypeId);
}
getAllCommentaire(demandeClientTypeId:number,employeeId) : Observable<Commentaire[]> {
  return this.httpClient.get<Commentaire[]>(this.baseUR17);
}
getTypeClient(demandeClientTypeId: number): Observable<any> {
  return this.httpClient.get(`${this.baseURl8}/find/${demandeClientTypeId}`);
}
}
