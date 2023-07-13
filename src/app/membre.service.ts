import { Injectable } from '@angular/core';
import { Membre } from './Models/Membre';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class MembreService {
  currentMembre: Membre | null = null;

  private baseUrl:string = "http://localhost:8089/SpringMVC/membre"

  constructor(private http: HttpClient) { }

  getMembre(membreId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/membre/${membreId}`);
  }
  public  loginMembre(membre:Membre) : Observable<any> {
   return this.http.post<any>("http://localhost:8089/SpringMVC/membre/login",membre);
  }

  public registreMembre(membre:Membre) : Observable<any>{
    return this.http.post<any>("http://localhost:8089/SpringMVC/membre/registreMembre",membre);
   }
   getMembreList(): Observable<Membre[]> {
    return this.http.get<Membre[]>("http://localhost:8089/SpringMVC/membre/membres");

  }





  }
