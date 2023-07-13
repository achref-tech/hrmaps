import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VersionDemandeListComponent } from './version-demande-list.component';

describe('VersionDemandeListComponent', () => {
  let component: VersionDemandeListComponent;
  let fixture: ComponentFixture<VersionDemandeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VersionDemandeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VersionDemandeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
