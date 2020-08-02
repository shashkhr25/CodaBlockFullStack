import { TestBed } from '@angular/core/testing';

import { CodaService } from './coda.service';

describe('CodaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CodaService = TestBed.get(CodaService);
    expect(service).toBeTruthy();
  });
});
