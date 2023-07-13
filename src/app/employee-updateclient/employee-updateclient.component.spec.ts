import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeUpdateclientComponent } from './employee-updateclient.component';

describe('EmployeeUpdateclientComponent', () => {
  let component: EmployeeUpdateclientComponent;
  let fixture: ComponentFixture<EmployeeUpdateclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeUpdateclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeUpdateclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
