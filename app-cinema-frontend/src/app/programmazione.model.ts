// src/app/programmazione.model.ts

export interface Programmazione {
  formattedDataInizio: any;
  formattedDataFine: any;
  id: number;
  dataInizio: string;
  dataFine: string;
  filmId: number;
  salaId: number;
  filmDetails?: FilmDetails;
  salaDetails?: SalaDetails;
}

export interface FilmDetails {
  id: number;
  nome: string;
  genere: string;
  regia: string;
  durata: number;
  coverUrl: string;
}

export interface SalaDetails {
  id: number;
  nome: string;
  capienza: number;
  flagImax: boolean;
}
