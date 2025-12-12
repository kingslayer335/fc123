import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

@Injectable({ providedIn: 'root' })
export class PlayerDb {

  private url = 'http://localhost:8080/api/db/player';

  constructor(private http: HttpClient) {}

  savePlayer(username: string) {
    return this.http.post<any>(
      `${this.url}?username=${username}`,
      {}
    );
  }
}