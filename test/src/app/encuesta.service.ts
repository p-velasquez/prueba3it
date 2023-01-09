import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from "src/environments/environment";
import { Encuesta } from './encuesta';

@Injectable({
  providedIn: 'root'
})
export class EncuestaService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) { }
  addEncuesta(encuesta:Encuesta) : Observable<object>
  {
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(encuesta);
    return this.http.post(`${this.apiServerUrl}/generar-encuesta`, body,{'headers':headers});
  }
  
  getResultados() : Observable<object>
  {
    return this.http.get(`${this.apiServerUrl}/resultados`);
  }

}