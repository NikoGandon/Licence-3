import { Component, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginForm = inject(FormBuilder);

  form = this.loginForm.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  });

  httpClient = inject(HttpClient);

  onSubmit(): void {
    this.httpClient.post('http://localhost:3000/User/login', {
      username: this.form.value.username,
      password: this.form.value.password,
    });
  }
  
}
