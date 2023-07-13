import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientVersionrecentComponent } from './client-versionrecent.component';

describe('ClientVersionrecentComponent', () => {
  let component: ClientVersionrecentComponent;
  let fixture: ComponentFixture<ClientVersionrecentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientVersionrecentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientVersionrecentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
