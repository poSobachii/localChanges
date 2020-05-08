import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  getAll(): Observable<string[]> {
    return of(['Document 1', 'Document 2']);
  }
}
