import { Injectable } from '@angular/core';
import { Sale } from './sale';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

const apiUrl = 'http://127.0.0.1:8080/api/sales';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  constructor(private http: HttpClient) { }

  getSalesList(): Observable<any> {
    return this.http.get(`${apiUrl}`);
  }
}
