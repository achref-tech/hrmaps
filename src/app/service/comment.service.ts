import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, forkJoin, map, switchMap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private cancelCommentSource = new Subject<void>();
  cancelComment$ = this.cancelCommentSource.asObservable();
  private baseUrl:string = "http://localhost:8089/SpringMVC/commentaire"
  comments ! : any

  cancelComment() {
    this.cancelCommentSource.next();
  }
  deleteCommentsByDemandeClientTypeId(demandeClientTypeId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/comments/${demandeClientTypeId}`);
  }
  
  deletecomment( idComm: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/remove-comment/${ idComm}`, { responseType: 'text' });
  }

  constructor(private http: HttpClient) { }
}
