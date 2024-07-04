import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FilmService {
  private baseUrl = 'http://localhost:8080/cinema';

  constructor(private http: HttpClient) {}

  getFilmById(id: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/filmbyid`, { id });
  }

  getAllProgrammazioni(): Observable<any> {
    return this.http.get(`${this.baseUrl}/allprogrammazioni`);
  }
}
