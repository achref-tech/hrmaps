import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccepteDemandecongeComponent } from './accepte-demandeconge.component';

describe('AccepteDemandecongeComponent', () => {
  let component: AccepteDemandecongeComponent;
  let fixture: ComponentFixture<AccepteDemandecongeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccepteDemandecongeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccepteDemandecongeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
