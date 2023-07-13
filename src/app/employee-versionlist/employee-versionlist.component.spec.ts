import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeVersionlistComponent } from './employee-versionlist.component';

describe('EmployeeVersionlistComponent', () => {
  let component: EmployeeVersionlistComponent;
  let fixture: ComponentFixture<EmployeeVersionlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeVersionlistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeVersionlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
