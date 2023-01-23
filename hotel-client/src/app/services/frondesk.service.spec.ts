import { TestBed } from '@angular/core/testing';

import { FrondeskService } from './frondesk.service';

describe('FrondeskService', () => {
  let service: FrondeskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FrondeskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
