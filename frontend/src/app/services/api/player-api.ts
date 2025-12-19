import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {EMPTY, Observable} from 'rxjs';

export interface PlayerResponse {
  player: any;
  cs2: any;
  stats: any;
}

@Injectable({providedIn: 'root'})
export class PlayerApi {
  private readonly http = inject(HttpClient);
  private readonly API_URL = '/api/player';

  getPlayer(username: string ): Observable<PlayerResponse> {
    if (!username) return EMPTY;
    const params = new HttpParams().set('username', username.trim());
    return this.http.get<PlayerResponse>(this.API_URL, {params});
  }
}
