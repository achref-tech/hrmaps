import { TestBed } from '@angular/core/testing';

import { VersionserviceService } from './versionservice.service';

describe('VersionserviceService', () => {
  let service: VersionserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VersionserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
