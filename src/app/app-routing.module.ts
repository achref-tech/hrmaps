import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ClientListComponent } from './client-list/client-list.component';
import { UpdateClientComponent } from './update-client/update-client.component';
import { AffecterversionclientComponent } from './affecterversionclient/affecterversionclient.component';
import { VersionListComponent } from './version-list/version-list.component';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { AddClientComponent } from './add-client/add-client.component';
import { ClientVersionrecentComponent } from './client-versionrecent/client-versionrecent.component';
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
import { LoginEmployeeComponent } from './login-employee/login-employee.component';
import { CodeComponent } from './code/code.component';
import { RegistreEmployeeComponent } from './registre-employee/registre-employee.component';
import { WelcomeEmployeeComponent } from './welcome-employee/welcome-employee.component';
import { EmployeeListclientComponent } from './employee-listclient/employee-listclient.component';
import { EmployeeUpdateclientComponent } from './employee-updateclient/employee-updateclient.component';
import { EmployeeVersionlistComponent } from './employee-versionlist/employee-versionlist.component';
import { EmployeeAffecterclientComponent } from './employee-affecterclient/employee-affecterclient.component';
import { EmployeeDetailsclientComponent } from './employee-detailsclient/employee-detailsclient.component';
import { EmployeeAddclientComponent } from './employee-addclient/employee-addclient.component';
import { EmployeeDemandeclientlistComponent } from './employee-demandeclientlist/employee-demandeclientlist.component';
import { EmployeeListdemandeclientComponent } from './employee-listdemandeclient/employee-listdemandeclient.component';
import { CongeComponent } from './conge/conge.component';
import { CongeListComponent } from './conge-list/conge-list.component';
import { CreateVoteComponent } from './create-vote/create-vote.component';
import { CreateCommentaireComponent } from './create-commentaire/create-commentaire.component';
import { AcceptedemandeComponent } from './acceptedemande/acceptedemande.component';
import { AccepteDemandecongeComponent } from './accepte-demandeconge/accepte-demandeconge.component';
import { ReponseCongeComponent } from './reponse-conge/reponse-conge.component';
import { EtatDemandeComponent } from './etat-demande/etat-demande.component';
import { VoteEmployeeComponent } from './vote-employee/vote-employee.component';
import { AdminEmployeeComponent } from './admin-employee/admin-employee.component';
import { AffecterEmployeeComponent } from './affecter-employee/affecter-employee.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
  },
  
{
    path:'login',
     component: LoginComponent, 
  },

  {
    path:'login/login-user/registration',
     component: RegistrationComponent, 
  },
  {
    path:'login/login-employee/registre-employee',
     component: RegistreEmployeeComponent, 
  },
  {
    path:'login/login-employee',
     component: LoginEmployeeComponent, 
  },
  {
    path:'welcome-employee',
     component: WelcomeEmployeeComponent, 
  },
  { path :'create-vote/:demandeclientTypeId/:employeeId/:note',component:CreateVoteComponent},
  { path :'create-commentaire/:employeeId/:demandeClientTypeId',component:CreateCommentaireComponent},


  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'home/client-list',
    component: ClientListComponent,
  },
  {
    path: 'employee-listclient',
    component:EmployeeListclientComponent,
  },
  {
    path: 'employee-versionlist',
    component:EmployeeVersionlistComponent,
  },
  {
    path: 'employee-listdemandeclient',
    component:EmployeeListdemandeclientComponent,
  },
  {
    path: 'login/code',
    component: CodeComponent,
  },
  {
    path: 'acceptedemande/:demandeClientTypeId',
    component: AcceptedemandeComponent,
  },
  {
    path: 'login/login-user',
    component: LoginUserComponent,
  },
  {
    path:'login-user/:membreId',
    component:LoginUserComponent,
  },

  {
    path: 'login/login-admin',
    component: LoginAdminComponent,
  },
  
  {
    path: 'demande-client',
     component: DemandeClientComponent,
  },
  {
    path: 'conge-list',
     component: CongeListComponent,
  },

  {
    path: 'conge',
     component: CongeComponent,
  },
  {
    path:'demande-client/add-demandeclient',
    component: AddDemandeclientComponent,
  },

  {
    path:'home/demandeclient-list',
    component: DemandeclientListComponent,
  },
  {
    path:'demande-client/version-demande-list',
    component:VersionDemandeListComponent,
  },
  
  
  {
    path: 'home/client-list/update-client/:clientId',
    component: UpdateClientComponent,
  },
  {
    path: 'employee-listclient/employee-updateclient/:clientId',
    component: EmployeeUpdateclientComponent,
  },
  {
    path: 'demande-sucess',
    component: DemandeSucessComponent,
  },
  {
    path:'send-mail',
    component:SendMailComponent,
  },
  {
    path:'mail-list',
    component:MailListComponent,
  },
  {
    path:'welcome-quiz',
    component:WelcomeQuizComponent,
  },
  {
    path:'question-quiz',
    component:QuestionQuizComponent,
  },
   
  {
    path: 'home/client-list/version-list/:clientId/:clinetDateDebutDemande/:clientDateFinDemande',
    component: VersionListComponent,
  },
  

  {
    path: 'employee-listclient/employee-affecterclient/:clientId',
    component: EmployeeAffecterclientComponent,
  },
  {
    path: 'employee-addclient',
    component: EmployeeAddclientComponent,
  },
  {
    path: 'home/client-list/affecterversionclient/:clientId',
    component: AffecterversionclientComponent,
  },
  {
    path: 'affecter-employee/:demandeClientTypeId',
    component: AffecterEmployeeComponent,
  },

  {
    path: 'home/client-list/client-details/:clientId',
    component: ClientDetailsComponent,
  },
  {
    path: 'employee-listclient/employee-detailsclient/:clientId',
    component: EmployeeDetailsclientComponent,
  },
  {
    path: 'home/add-client',
    component: AddClientComponent,
  },
  {
    path: 'add-client/:demandeClientTypeId',
    component: AddClientComponent,
  },
  {
    path: 'accepte-demandeconge',
    component: AccepteDemandecongeComponent,
  },
  {
    path: 'vote-employee/:demandeClientTypeId',
    component: VoteEmployeeComponent,
  },
  {
    path: 'reponse-conge',
    component: ReponseCongeComponent,
  },
  {
    path: 'admin-employee',
    component: AdminEmployeeComponent,
  },
  {
    path: 'etat-demande',
    component: EtatDemandeComponent,
  },
  {
    path: 'home/client-versionrecent',
    component:ClientVersionrecentComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
