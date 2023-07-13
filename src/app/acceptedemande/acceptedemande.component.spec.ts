import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptedemandeComponent } from './acceptedemande.component';

describe('AcceptedemandeComponent', () => {
  let component: AcceptedemandeComponent;
  let fixture: ComponentFixture<AcceptedemandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcceptedemandeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AcceptedemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
