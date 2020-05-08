import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export abstract class CommonService {
  abstract getAll(): Observable<string[]>;
}
