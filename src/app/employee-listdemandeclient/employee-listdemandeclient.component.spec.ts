import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListdemandeclientComponent } from './employee-listdemandeclient.component';

describe('EmployeeListdemandeclientComponent', () => {
  let component: EmployeeListdemandeclientComponent;
  let fixture: ComponentFixture<EmployeeListdemandeclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListdemandeclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListdemandeclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
