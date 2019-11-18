import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDiskComponent } from './create-disk.component';

describe('CreateDiskComponent', () => {
  let component: CreateDiskComponent;
  let fixture: ComponentFixture<CreateDiskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateDiskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDiskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
