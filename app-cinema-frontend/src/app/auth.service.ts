import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/user'; // URL del backend
  private isAuthenticatedSubject: BehaviorSubject<boolean> ;
  public isAuthenticated: Observable<boolean>;

  constructor(private http: HttpClient) {
    localStorage.removeItem('currentUser');
    const currentUser = JSON.parse(localStorage.getItem('currentUser')!);
    this.isAuthenticatedSubject = new BehaviorSubject<boolean>(!!currentUser);
    this.isAuthenticated = this.isAuthenticatedSubject.asObservable();
  }

  public get isAuthenticatedValue(): boolean {
    return this.isAuthenticatedSubject.value;
  }

  login(username: string, password: string) {
    return this.http
      .post<any>(`${this.apiUrl}/login`, { username, password })
      .pipe(
        map((user) => {
          if (user) {
            localStorage.setItem('currentUser', JSON.stringify(user));
            this.isAuthenticatedSubject.next(true);
          }
          return user;
        })
      );
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.isAuthenticatedSubject.next(false);
  }

  isAuthenticatedUser(): boolean {
    return this.isAuthenticatedSubject.value;
  }
}
