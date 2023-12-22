import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private isAuthenticated = false;
  private API_URL = 'http://127.0.0.1:3000';

  constructor(private http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
    });
  }

  register(username: string, password: string): Observable<Boolean> {
    const body = {
      username: username,
      password: password,
    };

    return this.http.post<Boolean>(`${this.API_URL}/register`, body, {
      headers: this.getHeaders(),
    });
  }

  login(username: string, password: string): Observable<Boolean> {
    const body = {
      username: username,
      password: password,
    };

    return this.http.post<Boolean>(`${this.API_URL}/login`, body, {
      headers: this.getHeaders(),
    });
  }

  isAuth(): Observable<Boolean> {
    return of(this.isAuthenticated);
  }
}
