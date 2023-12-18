import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent implements OnInit{
onSubmit() {
throw new Error('Method not implemented.');
}
  httpClient: HttpClient;
loginForm: any;
  
  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  login(username: string, password: string): void {
    this.httpClient.post('http://localhost:3000/User/login', {username: username, password: password}).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
