import { Component, OnInit } from '@angular/core';
import { Hero } from '../superHero';
import { HeroService } from '../hero.service';
import { MessageServiceService } from '../message-service.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {
  anotherHeroVar: Hero = {
    id: 94,
    name: 'superHero'
  };
  someHeroVar = 'Windstorm';
  heroesLists: Hero[];

  selectedHero: Hero;


  onSelect(hero3: Hero): void {
    this.selectedHero = hero3;
    this.messssssageService.add(`HeroService: Selected hero id=${hero3.id}`);
  }

  constructor(private heroService: HeroService, private messssssageService: MessageServiceService) { }

  ngOnInit(): void {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes().subscribe(hers => this.heroesLists = hers);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroService.addHero({ name } as Hero)
      .subscribe(hero => {
        this.heroesLists.push(hero);
      });
  }

  delete(hero: Hero): void {
    this.heroesLists = this.heroesLists.filter(h => h !== hero);
    this.heroService.deleteHero(hero).subscribe();
  }

}
