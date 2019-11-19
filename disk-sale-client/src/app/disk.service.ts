import { Injectable } from '@angular/core';
import { Disk } from './disk';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

const apiUrl = 'http://127.0.0.1:8080/api/disks';

@Injectable({
  providedIn: 'root'
})
export class DiskService {

  constructor(private http: HttpClient) { }

  getDisks(): Observable<Disk[]> {
    return this.http.get<Disk[]>(apiUrl)
      .pipe(
        tap(_ => this.log('fetched Disks')),
        catchError(this.handleError('getDisks', []))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(error); // log to console instead
      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(message);
  }

  createDisk(disk: Object): Observable<Object> {
    return this.http.post(`${apiUrl}`, disk);
  }

  getDisk(id: string): Observable<any> {
    return this.http.get(`${apiUrl}/${id}`);
  }

  updateDisk(id: string, value: any): Observable<Object> {
    return this.http.put(`${apiUrl}/${id}`, value);
  }

  deleteDisk(id: string): Observable<any> {
    return this.http.delete(`${apiUrl}/${id}`, { responseType: 'text' });
  }

  getDisksList(): Observable<any> {
    return this.http.get(`${apiUrl}`);
  }
}
