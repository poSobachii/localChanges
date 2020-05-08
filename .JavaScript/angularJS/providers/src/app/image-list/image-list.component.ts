import { Component } from '@angular/core';
import { CommonService } from '../core/common.service';
import { ImageService } from '../core/image-service';
import { CommonListComponent } from '../common-list/common-list.component';

@Component({
  selector: 'app-image-list',
  templateUrl: '../common-list/common-list.component.html',
  providers: [
    { provide: CommonService, useClass: ImageService }
  ]
})
export class ImageListComponent extends CommonListComponent {
}
