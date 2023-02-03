import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FormComponent } from './template/form/form.component';
import { HomeComponent } from './template/home/home.component';
import { ListComponent } from './template/list/list.component';


const routes: Routes = [
  {path:'cadastro', component: FormComponent},
  {path:'list', component:ListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
