import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgrammazioneService } from './programmazione.service';
import { FilmListComponent } from './film-list/film-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EventEmitter } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet, CommonModule,
    FilmListComponent,
    FormsModule,
    HttpClientModule,
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [ProgrammazioneService],
})
export class AppComponent implements OnInit {
  title = 'Cinema App - Gestione Programmazione';
  errorMessage: string | null = null;
  loginData = { username: '', password: '' };
  isLoggedIn = false;
  loginError: string | null = null;
  showLoginForm = false;
  selectedFile: File | null = null;
  showSuccessAnimation = false;
  uploadSuccessEvent = new EventEmitter<void>();

  constructor(private programmazioneService: ProgrammazioneService) {}

  ngOnInit() {}

  toggleLoginForm() {
    this.showLoginForm = !this.showLoginForm;
  }
  
  
}
