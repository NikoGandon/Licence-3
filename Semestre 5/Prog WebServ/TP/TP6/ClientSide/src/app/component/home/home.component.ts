import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  title = 'Client';
  
  paragraph: string | undefined;

  constructor(private http: HttpClient) {
    this.http.get('http://localhost:3000/Hey').subscribe((response: any) => {
      this.paragraph = response.message;
      console.log(response.message);
    });
  }
}
