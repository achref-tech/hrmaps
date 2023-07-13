import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MailServiceService {
  private baseUrl:string ="http://localhost:8089/SpringMVC/send-email"
  //public formData: FormGroup;
  constructor(private http:HttpClient) { }
  sendEmail(to: string, subject: string, text: string): Observable<any> {
    const mail = { to, subject, text };
    return this.http.post<any>(this.baseUrl, mail);
  }

}

  /*createData(info:Object):Observable<Object> {
    alert("save email");
    return this.http.post(`${this.baseUrl}`,info)
  }
  getAll(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}*/
