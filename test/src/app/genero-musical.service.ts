import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class GeneroMusicalService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) { }
  getGenerosMusicales() : Observable<object>
  {
    return this.http.get(`${this.apiServerUrl}/generos-musicales`);
  }
}
