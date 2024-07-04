import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Programmazione, SalaDetails } from './programmazione.model';
import { FilmDetails } from './programmazione.model';

@Injectable({
  providedIn: 'root',
})
export class ProgrammazioneService {
  private apiUrl = 'http://localhost:8080/cinema';
  private apiUserUrl = 'http://localhost:8080/user';

  constructor(private http: HttpClient) {}

  getAllProgrammazioni(): Observable<Programmazione[]> {
    return this.http.get<Programmazione[]>(`${this.apiUrl}/allprogrammazioni`);
  }

  getSalaByNome(nome: string): Observable<SalaDetails> {
    return this.http.post<SalaDetails>(`${this.apiUrl}/salabynome`, { nome });
  }

  getSalaById(id: number): Observable<SalaDetails> {
    return this.http.post<SalaDetails>(`${this.apiUrl}/salabyid`, { id });
  }

  getFilmById(id: number): Observable<FilmDetails> {
    return this.http.post<FilmDetails>(`${this.apiUrl}/filmbyid`, { id });
  }

  getProgrammazioneById(id: number): Observable<Programmazione> {
    return this.http.post<Programmazione>(`${this.apiUrl}/programmazionebyid`, {
      id,
    });
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUserUrl}/login`, {
      username,
      password,
    });
  }

  uploadProgrammazione(formData: FormData): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/uploadprogrammazione`, formData);
  }
}
