import { TestBed } from '@angular/core/testing';

import { PlayerApi } from './player-api';

describe('PlayerApi', () => {
  let service: PlayerApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayerApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
