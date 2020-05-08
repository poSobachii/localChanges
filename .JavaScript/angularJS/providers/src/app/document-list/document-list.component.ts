import { Component } from '@angular/core';
import { CommonService } from '../core/common.service';
import { DocumentService } from '../core/document.service';
import { CommonListComponent } from '../common-list/common-list.component';

@Component({
  selector: 'app-document-list',
  templateUrl: '../common-list/common-list.component.html',
  providers: [
    { provide: CommonService, useClass: DocumentService }
  ]
})
export class DocumentListComponent extends CommonListComponent {
}
