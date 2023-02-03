
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Data } from '../module/data';




@Injectable({
  providedIn: 'root'
})
export class PessoaService {
 API: string = "http://localhost:3000/dados"
  constructor(private http:HttpClient) { }

  getAll() : Observable<Data[]> {
    return this.http.get<Data[]>(this.API)
  }

  geById(id:number): Observable<Data>{
    return this.http.get<Data>(`${this.API}/${id}`)
  }

  post(valor: Data) : Observable<Data>{
    return this.http.post<Data>(this.API, valor)
  }

  update(valor: Data) : Observable<Data>{
    const url= `${this.API}/${valor.id}`
    return this.http.put<Data>(url, valor)
  }

  delete(id: number) : Observable<Data>{
    return this.http.delete<Data>(`${this.API}/${id}`)
  }
}
