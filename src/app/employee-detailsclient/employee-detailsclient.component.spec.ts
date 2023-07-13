import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeDetailsclientComponent } from './employee-detailsclient.component';

describe('EmployeeDetailsclientComponent', () => {
  let component: EmployeeDetailsclientComponent;
  let fixture: ComponentFixture<EmployeeDetailsclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeDetailsclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeDetailsclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
