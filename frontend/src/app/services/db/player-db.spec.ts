import { TestBed } from '@angular/core/testing';

import { PlayerDb } from './player-db';

describe('PlayerDb', () => {
  let service: PlayerDb;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayerDb);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
