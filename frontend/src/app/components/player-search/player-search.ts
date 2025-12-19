import {Component, signal, computed, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {rxResource} from '@angular/core/rxjs-interop'
import {PlayerApi, PlayerResponse} from '../../services/api/player-api';
import {EMPTY} from 'rxjs';

@Component({
  selector: 'app-player-search',
  standalone: true,
  templateUrl: './player-search.html',
  imports: [FormsModule, CommonModule],
})
export class PlayerSearch {
  private readonly api = inject(PlayerApi)
  username = signal('');
  private hasSearched = signal(false);
  private searchUsername = signal<string | null>(null);

  playerResource = rxResource<PlayerResponse | null, string | null>({
    params: () => this.searchUsername(),
    stream: ({params}) => {
      if (!params) {
        return EMPTY;
      }
      return this.api.getPlayer(params);
    },
    defaultValue: null,
  });

  data = computed(() =>
    this.playerResource.hasValue() ? this.playerResource.value() : null);
  hasData = computed(() => this.playerResource.hasValue());
  loading = computed(() => this.playerResource.isLoading());
  error = computed(() => {
    if (!this.hasSearched()) return undefined;
    return this.playerResource.error() ? 'Player not found' : undefined;
  });

  search() {
    const trimmed = this.username().trim();
    if (trimmed) {
      this.hasSearched.set(true);
      this.searchUsername.set(trimmed);
    }
  }

  playerAvatar = computed(() => this.data()?.player?.avatar || "assets/images/faceit_default.jpg");

  isWin(win: boolean) {
    return win ? "bg-emerald-500 text-emerald-950" : "bg-[#CA3E3F] text-red-950";
  }

  getLevelUrl(level: number) {
    return `/assets/images/levels/${level}.svg`;
  }

  formatEloDelta(delta: number | null | undefined): string {
    if (delta === null || delta === undefined) return '---';
    return delta > 0 ? `+${delta}` : delta.toString();
  }

  getEloGainColor(stats: boolean) {
    return stats ? 'text-emerald-500' : 'text-[#CA3E3F]';
  }

  matchEloEmpty(matchElo: number, defaultElo: number) {
    return matchElo === null ? defaultElo : matchElo;
  }

  getMapImage(map: string) {
    return `/assets/images/maps/${map.toLowerCase()}.jpg`;
  }

  getCountryFlag(country: string | null | undefined) {
    if (!country) return 'https://flagcdn.com/w320/un.png';
    return `https://flagcdn.com/w320/${country.toLowerCase()}.png`;
  }

  getEloColor(elo: number) {
    if (elo >= 2000) return 'text-[#FE1F00]';
    if (elo >= 1530) return 'text-orange-500';
    if (elo >= 900) return 'text-yellow-300';
    if (elo >= 500) return 'text-[#1CE400]';
    return 'text-gray-500';
  }
}
