import { TestBed } from '@angular/core/testing';

import { DemandeclientService } from './demandeclient.service';

describe('DemandeclientService', () => {
  let service: DemandeclientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemandeclientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
