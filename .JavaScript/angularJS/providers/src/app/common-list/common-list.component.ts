import { OnInit } from '@angular/core';
import { CommonService } from '../core/common.service';

export class CommonListComponent implements OnInit {
  lines: string[];

  constructor(private service: CommonService) {
  }

  ngOnInit(): void {
    this.service.getAll()
      .subscribe(lines => this.lines = lines);
  }

  onClick(line) {
    alert(line);
  }

}
