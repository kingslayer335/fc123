import { TestBed } from '@angular/core/testing';

import { PlayerSearch } from './player-search';

describe('PlayerSearch', () => {
  let service: PlayerSearch;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayerSearch);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
