import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeDemandeclientlistComponent } from './employee-demandeclientlist.component';

describe('EmployeeDemandeclientlistComponent', () => {
  let component: EmployeeDemandeclientlistComponent;
  let fixture: ComponentFixture<EmployeeDemandeclientlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeDemandeclientlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeDemandeclientlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
