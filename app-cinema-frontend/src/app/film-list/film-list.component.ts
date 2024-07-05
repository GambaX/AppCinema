import { Component, OnInit, Input, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgrammazioneService } from '../programmazione.service';
import { Programmazione } from '../programmazione.model';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { forkJoin } from 'rxjs';
import { AuthService } from '../auth.service';  


@Component({
  selector: 'app-film-list',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.scss'],
})
export class FilmListComponent implements OnInit {
  @Input() uploadSuccessEvent!: EventEmitter<void>;
  programmazioni: Programmazione[] = [];
  otherProgrammazioni: Programmazione[] = [];
  liveProgrammazioni: Programmazione[] = [];
  activeProgrammazioni: Programmazione[] = [];
  allProgrammazioni: Programmazione[] = [];
  errorMessage: string | null = null;
  selectedStartDate: string | null = null;
  selectedEndDate: string | null = null;
  isLoggedIn = false; // Proprietà per gestire lo stato di login

  constructor(
    private authService: AuthService,
    private programmazioneService: ProgrammazioneService
  ) {}

  ngOnInit() {
    this.loadProgrammazioni();
    this.isLoggedIn = this.authService.isAuthenticatedUser();
    if (this.uploadSuccessEvent) {
      this.uploadSuccessEvent.subscribe(() => {
        this.loadProgrammazioni();
      });
    }
  }

  onDateChange() {
    this.filterProgrammazioni();
  }

  loadProgrammazioni() {
    this.programmazioneService.getAllProgrammazioni().subscribe({
      next: (programmazioni) => {
        if (programmazioni && programmazioni.length > 0) {
          const filmDetailsObservables = programmazioni.map((programmazione) =>
            this.programmazioneService.getFilmById(programmazione.filmId)
          );
          const salaDetailsObservables = programmazioni.map((programmazione) =>
            this.programmazioneService.getSalaById(programmazione.salaId)
          );
          forkJoin([
            forkJoin(filmDetailsObservables),
            forkJoin(salaDetailsObservables),
          ]).subscribe(([filmDetailsArray, salaDetailsArray]) => {
            programmazioni.forEach((programmazione, index) => {
              programmazione.filmDetails = filmDetailsArray[index];
              programmazione.salaDetails = salaDetailsArray[index];
            });

            this.programmazioni = programmazioni;
            this.allProgrammazioni = programmazioni;
            this.filterProgrammazioni();
          });
        } else {
          this.errorMessage =
            'No data found for resource with given identifier';
        }
      },
      error: (error) => {
        console.error('Error fetching programmazioni', error);
        this.errorMessage = 'Error fetching programmazioni';
      },
    });
  }

  filterProgrammazioni() {
    const currentDate = new Date();


    if (this.isLoggedIn) {
    this.liveProgrammazioni = [];
    this.otherProgrammazioni = [];
    this.activeProgrammazioni = this.allProgrammazioni;
    return;
  }

    if (!this.selectedStartDate || !this.selectedEndDate) {
      this.liveProgrammazioni = [];
      this.otherProgrammazioni = [];
      this.activeProgrammazioni = [];

      this.activeProgrammazioni = this.allProgrammazioni.filter(
        (p: Programmazione) => new Date(p.dataFine) > currentDate
      );
    } else if (this.selectedStartDate && this.selectedEndDate) {
      const startDate = new Date(this.selectedStartDate);
      const endDate = new Date(this.selectedEndDate);

      this.liveProgrammazioni = this.activeProgrammazioni.filter(
        (p: Programmazione) =>
          (new Date(p.dataInizio) >= startDate &&
            new Date(p.dataInizio) <= endDate) ||
          (new Date(p.dataFine) >= startDate && new Date(p.dataFine) <= endDate)
      );

      this.otherProgrammazioni = this.activeProgrammazioni.filter(
        (p: Programmazione) =>
          !(
            (new Date(p.dataInizio) >= startDate &&
              new Date(p.dataInizio) <= endDate) ||
            (new Date(p.dataFine) >= startDate &&
              new Date(p.dataFine) <= endDate)
          )
      );
    } else {
      this.otherProgrammazioni = [];
      this.liveProgrammazioni = [];
    }
  }

  logout() {
    this.authService.logout();
    this.isLoggedIn = false;
    window.location.href = ''; 
  }
}
