import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeAffecterclientComponent } from './employee-affecterclient.component';

describe('EmployeeAffecterclientComponent', () => {
  let component: EmployeeAffecterclientComponent;
  let fixture: ComponentFixture<EmployeeAffecterclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeAffecterclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAffecterclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
