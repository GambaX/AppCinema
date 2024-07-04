import { Routes } from '@angular/router';
import { FilmListComponent } from './film-list/film-list.component';
import { ProgrammazioneFilmComponent } from './programmazione-film/programmazione-film.component';

export const routes: Routes = [
  { path: '', component: FilmListComponent },
  { path: 'programmazionefilm/:id', component: ProgrammazioneFilmComponent },
];
