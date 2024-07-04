import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilmListComponent } from './film-list/film-list.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', component: FilmListComponent },
  { path: 'login', component: LoginComponent },
  // Aggiungi altre rotte qui
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
