import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandeclientListComponent } from './demandeclient-list.component';

describe('DemandeclientListComponent', () => {
  let component: DemandeclientListComponent;
  let fixture: ComponentFixture<DemandeclientListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandeclientListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandeclientListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
