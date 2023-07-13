import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ClientListComponent } from './client-list/client-list.component';
import { HttpClient,HttpClientModule } from '@angular/common/http';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatIconModule } from '@angular/material/icon';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { TranslateHttpLoader} from '@ngx-translate/http-loader';
import { UpdateClientComponent } from './update-client/update-client.component';
import { AffecterversionclientComponent } from './affecterversionclient/affecterversionclient.component';
import { VersionListComponent } from './version-list/version-list.component';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { ClientVersionrecentComponent } from './client-versionrecent/client-versionrecent.component';
import { AddClientComponent } from './add-client/add-client.component';
import { LoginComponent } from './login/login.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { DemandeClientComponent } from './demande-client/demande-client.component';
import { RegistrationComponent } from './registration/registration.component';
import { AddDemandeclientComponent } from './add-demandeclient/add-demandeclient.component';
import { DemandeclientListComponent } from './demandeclient-list/demandeclient-list.component';
import { VersionDemandeListComponent } from './version-demande-list/version-demande-list.component';
import { DemandeSucessComponent } from './demande-sucess/demande-sucess.component';
import { SendMailComponent } from './send-mail/send-mail.component';
import { MailListComponent } from './mail-list/mail-list.component';
import { WelcomeQuizComponent } from './welcome-quiz/welcome-quiz.component';
import { QuestionQuizComponent } from './question-quiz/question-quiz.component';
import { ChangeBdDirective } from './change-bd.directive';
import { LoginEmployeeComponent } from './login-employee/login-employee.component';
import { CodeComponent } from './code/code.component';
import { RegistreEmployeeComponent } from './registre-employee/registre-employee.component';
import { WelcomeEmployeeComponent } from './welcome-employee/welcome-employee.component';
import { EmployeeListclientComponent } from './employee-listclient/employee-listclient.component';
import { EmployeeUpdateclientComponent } from './employee-updateclient/employee-updateclient.component';
import { EmployeeDetailsclientComponent } from './employee-detailsclient/employee-detailsclient.component';
import { EmployeeAffecterclientComponent } from './employee-affecterclient/employee-affecterclient.component';
import { EmployeeVersionlistComponent } from './employee-versionlist/employee-versionlist.component';
import { EmployeeAddclientComponent } from './employee-addclient/employee-addclient.component';
import { EmployeeDemandeclientlistComponent } from './employee-demandeclientlist/employee-demandeclientlist.component';
import { CongeComponent } from './conge/conge.component';
import { CongeListComponent } from './conge-list/conge-list.component';
import { CreateVoteComponent } from './create-vote/create-vote.component';
import { CommentsComponent } from './comments/comments.component';
import { CreateCommentaireComponent } from './create-commentaire/create-commentaire.component';
import { MatDialogModule } from '@angular/material/dialog';
import { EmployeeListdemandeclientComponent } from './employee-listdemandeclient/employee-listdemandeclient.component';
import { AcceptedemandeComponent } from './acceptedemande/acceptedemande.component';
import { AccepteDemandecongeComponent } from './accepte-demandeconge/accepte-demandeconge.component';
import { ReponseCongeComponent } from './reponse-conge/reponse-conge.component';
import { EtatDemandeComponent } from './etat-demande/etat-demande.component';
import { VoteEmployeeComponent } from './vote-employee/vote-employee.component';
import { AdminEmployeeComponent } from './admin-employee/admin-employee.component';
import { AffecterEmployeeComponent } from './affecter-employee/affecter-employee.component';




export function Ts(http: HttpClient) {
  return new TranslateHttpLoader(http, 'assets/i18n/', '.json' );
}


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ClientListComponent,
    UpdateClientComponent,
    AffecterversionclientComponent,
    VersionListComponent,
    ClientDetailsComponent,
    ClientVersionrecentComponent,
    AddClientComponent,
    LoginComponent,
    LoginUserComponent,
    LoginAdminComponent,
    DemandeClientComponent,
    RegistrationComponent,
    AddDemandeclientComponent,
    DemandeclientListComponent,
    VersionDemandeListComponent,
    DemandeSucessComponent,
    SendMailComponent,
    MailListComponent,
    WelcomeQuizComponent,
    QuestionQuizComponent,
    ChangeBdDirective,
    LoginEmployeeComponent,
    CodeComponent,
    RegistreEmployeeComponent,
    WelcomeEmployeeComponent,
    EmployeeListclientComponent,
    EmployeeListdemandeclientComponent,
    EmployeeUpdateclientComponent,
    EmployeeDetailsclientComponent,
    EmployeeAffecterclientComponent,
    EmployeeVersionlistComponent,
    EmployeeAddclientComponent,
    EmployeeDemandeclientlistComponent,
    CongeComponent,
    CongeListComponent,
    CreateVoteComponent,
    CommentsComponent,
    CreateCommentaireComponent,
    AcceptedemandeComponent,
    AccepteDemandecongeComponent,
    ReponseCongeComponent,
    EtatDemandeComponent,
    VoteEmployeeComponent,
    AdminEmployeeComponent,
    AffecterEmployeeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    SweetAlert2Module,
    SweetAlert2Module.forRoot(),
    TranslateModule.forRoot({
      loader: {
          provide: TranslateLoader,
          useFactory: (Ts),
          deps: [HttpClient]
        }
      }),
    NoopAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatIconModule,
    MatDialogModule
     ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
