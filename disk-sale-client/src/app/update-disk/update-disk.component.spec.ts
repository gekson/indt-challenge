import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDiskComponent } from './update-disk.component';

describe('UpdateDiskComponent', () => {
  let component: UpdateDiskComponent;
  let fixture: ComponentFixture<UpdateDiskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateDiskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDiskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
