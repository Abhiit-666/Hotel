import { TestBed } from '@angular/core/testing';

import { FrontdeskService } from './frontdesk.service';

describe('FrondeskService', () => {
  let service: FrontdeskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FrontdeskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
