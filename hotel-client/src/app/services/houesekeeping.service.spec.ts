import { TestBed } from '@angular/core/testing';

import { HouesekeepingService } from './houesekeeping.service';

describe('HouesekeepingService', () => {
  let service: HouesekeepingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HouesekeepingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
