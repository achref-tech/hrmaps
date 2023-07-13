import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AffecterEmployeeComponent } from './affecter-employee.component';

describe('AffecterEmployeeComponent', () => {
  let component: AffecterEmployeeComponent;
  let fixture: ComponentFixture<AffecterEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AffecterEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AffecterEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
