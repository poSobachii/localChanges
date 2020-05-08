import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ImageListComponent } from './image-list/image-list.component';
import { DocumentListComponent } from './document-list/document-list.component';

const routes: Routes = [
  {
    path: '',
    component: AppComponent
  },
  {
    path: 'images',
    component: ImageListComponent
  },
  {
    path: 'documents',
    component: DocumentListComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
