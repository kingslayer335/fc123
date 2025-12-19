import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({providedIn: 'root'})
export class PlayerDb {

  private url = 'http://localhost:8080/api/db/player';

  constructor(private http: HttpClient) {
  }

  savePlayer(username: string): Observable<void> {
    const params = new HttpParams().set('username', username);

    return this.http.post<void>(this.url, {}, {params});
  }
}
