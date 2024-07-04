import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgrammazioneService } from './programmazione.service';
import { FilmListComponent } from './film-list/film-list.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FilmListComponent, FormsModule, HttpClientModule],
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

  onSubmit() {
    this.programmazioneService
      .login(this.loginData.username, this.loginData.password)
      .subscribe({
        next: () => {
          this.isLoggedIn = true;
          this.loginError = null;
          this.showLoginForm = false;
        },
        error: (error: any) => {
          // Specifica il tipo qui
          console.error('Login error', error);
          this.loginError = 'Invalid username or password';
        },
      });
  }

  logout() {
    this.isLoggedIn = false;
    this.selectedFile = null;
  }

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    if (
      file &&
      file.type ===
        'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
    ) {
      this.selectedFile = file;
    } else {
      alert('Per favore seleziona un file Excel .xlsx valido');
    }
  }

  uploadFile() {
    if (this.selectedFile) {
      const formData = new FormData();
      formData.append('file', this.selectedFile);

      this.programmazioneService.uploadProgrammazione(formData).subscribe({
        next: () => {
          this.uploadSuccessEvent.emit(); // Emesso l'evento di upload riuscito
          this.showSuccessAnimation = true;
          setTimeout(() => {
            this.showSuccessAnimation = false;
          }, 3000); // L'animazione dura 3 secondi
          this.selectedFile = null;
          const input = document.querySelector(
            'input[type="file"]'
          ) as HTMLInputElement;
          if (input) {
            input.value = ''; // Resetta il valore dell'input file
          }
        },
        error: (error: any) => {
          // Specifica il tipo qui
          console.error('Error uploading file', error);
          alert('Error uploading file');
        },
      });
    }
  }
}
