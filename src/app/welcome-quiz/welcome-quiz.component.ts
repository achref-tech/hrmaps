import { Component, OnInit,ViewChild,ElementRef } from '@angular/core';

@Component({
  selector: 'app-welcome-quiz',
  templateUrl: './welcome-quiz.component.html',
  styleUrls: ['./welcome-quiz.component.css']
})
export class WelcomeQuizComponent implements OnInit {
  @ViewChild('name') nameKey!:ElementRef;

  constructor() { }

  ngOnInit(): void {
  }
  startQuiz(){
    localStorage.setItem("name",this.nameKey.nativeElement.value);
  }

}
