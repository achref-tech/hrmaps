import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteEmployeeComponent } from './vote-employee.component';

describe('VoteEmployeeComponent', () => {
  let component: VoteEmployeeComponent;
  let fixture: ComponentFixture<VoteEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoteEmployeeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoteEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
