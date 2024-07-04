import { TestBed } from '@angular/core/testing';

import { ProgrammazioneService } from './programmazione.service';

describe('ProgrammazioneService', () => {
  let service: ProgrammazioneService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProgrammazioneService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
