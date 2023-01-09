import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AcercaDeComponent } from 'src/app/acerca-de/acerca-de.component';
import { EncuestaComponent } from 'src/app/encuesta/encuesta.component';
import { ResultadosComponent } from 'src/app/resultados/resultados.component';

const routes: Routes = [
    { path: 'encuesta', component: EncuestaComponent },
    { path: 'resultados', component: ResultadosComponent },
    { path: 'acerca-de', component: AcercaDeComponent },
    { path: '', redirectTo: '/encuesta', pathMatch: 'full' }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
