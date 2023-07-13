import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeSucessComponent } from './demande-sucess.component';

describe('DemandeSucessComponent', () => {
  let component: DemandeSucessComponent;
  let fixture: ComponentFixture<DemandeSucessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandeSucessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeSucessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
