import { Component, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PlayerApi, PlayerResponse } from '../../services/api/player-api';
import { PlayerDb } from '../../services/db/player-db';

@Component({
  selector: 'app-player-search',
  standalone: true,
  templateUrl: './player-search.html',
  imports: [FormsModule, CommonModule],
})

export class PlayerSearch {
  username = '';
  data?: PlayerResponse;
  loading = false;
  error?: string;

  constructor(private api: PlayerApi, private db: PlayerDb, private cdr: ChangeDetectorRef) { }

  isWin(win: boolean) {
    if (win == true) {
      return "bg-emerald-500 text-emerald-950"
    }
    return "bg-[#CA3E3F] text-red-950"
  }

  getEloGainColor(stats: boolean) {
    return stats == true
      ? 'text-emerald-500'
      : 'text-[#CA3E3F]';
  }
  matchEloEmpty(elo: string, elo2: string) {
    if (elo === "") {
      return elo2;
    }
    return elo;
  }
  getMapImage(map: string) {
    return `/assets/images/maps/${map.toLowerCase()}.jpg`;
  }

  getEloColor(elo: number) {
    if (elo >= 2000) return 'text-[#FE1F00]';
    if (elo >= 1530) return 'text-orange-500';
    if (elo >= 900) return 'text-yellow-300';
    if (elo >= 500) return 'text-[#1CE400]';
    return 'text-gray-500';
  }
  getKdColor(kills: number, deaths: number) {
    if (kills >= deaths) return 'text-[#14FF00]'
    return 'text-[#ff0000]'
  }

  getAvatar(avatar: string) {
    if (!avatar) {
      return "assets/images/faceit_default.jpg"
    }
    return avatar;
  }

  search() {
    if (!this.username.trim()) {
      this.error = 'Enter a proper nickname';
      return;
    }

    this.loading = true;
    this.error = undefined;
    this.data = undefined;

    this.api.getPlayer(this.username).subscribe({
      next: (res) => {
        this.loading = false;
        this.data = res;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error(err);
        this.error = 'Error fetching player data';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
    this.db.savePlayer(this.username).subscribe({
      next: (res) => {
        this.data = res;
      }
    });
  }
}
