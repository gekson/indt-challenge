import { Component, OnInit } from '@angular/core';
import { DiskService } from '../disk.service';
import { Disk } from '../disk';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-disk',
  templateUrl: './create-disk.component.html',
  styleUrls: ['./create-disk.component.css']
})
export class CreateDiskComponent implements OnInit {

  disk: Disk = new Disk();
  submitted = false;

  constructor(private diskService: DiskService,
              private router: Router) { }

  ngOnInit() {
  }

  newDisk(): void {
    this.submitted = false;
    this.disk = new Disk();
  }

  save() {
    this.diskService.createDisk(this.disk)
      .subscribe(data => console.log(data), error => console.log(error));
    this.disk = new Disk();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/disks']);
  }
}
