import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vote } from '../Models/Vote';
import { DemandeClientType } from '../demande-client-type';


@Injectable({
  providedIn: 'root'
})
export class VoteService {
  private baseUR9:string = "http://localhost:8089/SpringMVC/add-votelike";
  private baseUR10:string = "http://localhost:8089/SpringMVC/retrieve-all-Vote";
  private baseURl2:string = "http://localhost:8089/SpringMVC/demandeclient/find";

  constructor(private httpClient :HttpClient) { }
  createVote(demandeclienttypeId:number,employeeId:number,note:number): Observable<object>{
    return this.httpClient.post(`${this.baseUR9}/${demandeclienttypeId}/${employeeId}/${note}`+demandeclienttypeId,employeeId+note);
}
getAllVote() : Observable<Vote[]> {
  return this.httpClient.get<Vote[]>(this.baseUR10);
}
getDemandeClientTypeById(demandeclienttypeId:number):Observable<DemandeClientType> {
  return this.httpClient.get<DemandeClientType>(`${this.baseURl2}/${demandeclienttypeId}`);
}

}

