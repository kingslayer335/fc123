import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PlayerSearch } from './components/player-search/player-search';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.html',
  styleUrl: './app.css',
  imports: [
    PlayerSearch
  ]
})
export class AppComponent {}