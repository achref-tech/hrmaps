import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AffecterversionclientComponent } from './affecterversionclient.component';

describe('AffecterversionclientComponent', () => {
  let component: AffecterversionclientComponent;
  let fixture: ComponentFixture<AffecterversionclientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AffecterversionclientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AffecterversionclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
