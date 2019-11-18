import { TestBed } from '@angular/core/testing';

import { DiskService } from './disk.service';

describe('DiskService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DiskService = TestBed.get(DiskService);
    expect(service).toBeTruthy();
  });
});
