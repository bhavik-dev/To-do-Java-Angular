import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Item } from '../interface/item.interface';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient,
  ) { }

  getAll(baseUrl: string): Observable<any> {
    return this.http.get(baseUrl);
  }
  get(id: number, baseUrl: string): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }
  create(data: Item, baseUrl: string): Observable<any> {
    return this.http.post(baseUrl, data);
  }
  update(id: number, data: Item, baseUrl: string): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
  delete(id: number, baseUrl: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
  deleteAll(baseUrl: string): Observable<any> {
    return this.http.delete(baseUrl);
  }
  findByTitle(title: string, baseUrl: string): Observable<any> {
    return this.http.get(`${baseUrl}?title=${title}`);
  }
}
