import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface PlayerResponse {
  player: any;
  playerCs2: any;
  playerStats: any;
}

@Injectable({
  providedIn: 'root'
})
export class PlayerApi {

  constructor(private http: HttpClient) {}

  getPlayer(username: string): Observable<PlayerResponse> {
    const params = new HttpParams().set('username', username);
    return this.http.get<PlayerResponse>('/api/player', { params });
  }
}