import { Component, OnInit } from '@angular/core';
import { Encuesta } from '../encuesta';
import { GeneroMusicalService } from '../genero-musical.service'
import { EncuestaService } from '../encuesta.service';
@Component({
  selector: 'app-encuesta',
  templateUrl: './encuesta.component.html',
  styleUrls: ['./encuesta.component.scss']
})
export class EncuestaComponent implements OnInit {
  generosMusicales : any;
  encuesta = new Encuesta;

  constructor(private serviceGeneroMusical : GeneroMusicalService, private serviceEncuesta : EncuestaService) {}

  ngOnInit(): void {
    this.encuesta.idGeneroMusical = 0;
    this.serviceGeneroMusical.getGenerosMusicales().subscribe(data =>{
      this.generosMusicales = data;
    });
  }
  
  addEncuesta() {
    this.serviceEncuesta.addEncuesta(this.encuesta)
    .subscribe(
      data => {
        document.getElementById("openModalSuccess")!.click();
      },
      error => {
        document.getElementById("openModalError")!.click();
      })   
  }

}
