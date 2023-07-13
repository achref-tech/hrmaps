import { HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../Models/Client';



@Injectable({
  providedIn: 'root'
})
export class TypeClientService {
  private baseUrl:string = "http://localhost:8089/SpringMVC/client"

  constructor(private http: HttpClient) { }
  getTypeClient(clientId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/client/${clientId}`);
  }

  createTypeClient(fd:FormData): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/add-client`,fd);
  }

  updateTypeClient(clientId : number , data:any): Observable<any> {
    return this.http.put<Client>(`${this.baseUrl}/client` , data);
  }


  deleteTypeClient(clientId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/clients/${clientId}`, { responseType: 'text' });
  }

  getTypeClientList(): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.baseUrl}/clients`);

  }
  affecterVersionclient(versionId:number,data:Client): Observable<any> {
    return this.http.put<Client>(`${this.baseUrl}/clientt/${versionId}`,data); 
  }
  findClientByRecentVersion():Observable<any> {
    return this.http.get("http://localhost:8089/SpringMVC/client/retrieve-maxversion");
  }

  file():Observable<any> {
    return this.http.get("http://localhost:8089/SpringMVC/client/file");
  }

}

