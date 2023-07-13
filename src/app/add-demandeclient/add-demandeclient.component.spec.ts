import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDemandeclientComponent } from './add-demandeclient.component';

describe('AddDemandeclientComponent', () => {
  let component: AddDemandeclientComponent;
  let fixture: ComponentFixture<AddDemandeclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddDemandeclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDemandeclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
