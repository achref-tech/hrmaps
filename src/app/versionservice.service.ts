import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Version } from '@angular/compiler';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class VersionserviceService {
  private baseUrl:string = "http://localhost:8089/SpringMVC/Version"

  constructor(private http: HttpClient) { }
  getVersion(): Observable<Version[]> {
    return this.http.get<Version[]>(`${this.baseUrl}/listeversion/`);
  }
  getTypeVersion(versionId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/findversion/${versionId}`);
  }
  

}

