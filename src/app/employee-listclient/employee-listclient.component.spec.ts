import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListclientComponent } from './employee-listclient.component';

describe('EmployeeListclientComponent', () => {
  let component: EmployeeListclientComponent;
  let fixture: ComponentFixture<EmployeeListclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
