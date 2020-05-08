import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ImageListComponent } from './image-list/image-list.component';
import { AppRoutingModule } from './app-routing.module';
import { DocumentListComponent } from './document-list/document-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ImageListComponent,
    DocumentListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
