import { Component, OnInit } from '@angular/core';
import { EncuestaService } from '../encuesta.service';

@Component({
  selector: 'app-resultados',
  templateUrl: './resultados.component.html',
  styleUrls: ['./resultados.component.scss']
})
export class ResultadosComponent implements OnInit {

  resultados : any;

  constructor(private serviceEncuesta : EncuestaService) { }

  ngOnInit(): void {
    this.serviceEncuesta.getResultados().subscribe(data =>{
      this.resultados = data;
    });
  }
}
