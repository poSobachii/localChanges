import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  getAll(): Observable<string[]> {
    return of(['Image 1', 'Image 2']);
  }
}
