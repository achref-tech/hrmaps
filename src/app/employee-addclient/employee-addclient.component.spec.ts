import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeAddclientComponent } from './employee-addclient.component';

describe('EmployeeAddclientComponent', () => {
  let component: EmployeeAddclientComponent;
  let fixture: ComponentFixture<EmployeeAddclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeAddclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAddclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
