import { Component, OnInit } from '@angular/core';
import { Disk } from '../disk';
import { ActivatedRoute, Router } from '@angular/router';
import { DiskService } from '../disk.service';

@Component({
  selector: 'app-update-disk',
  templateUrl: './update-disk.component.html',
  styleUrls: ['./update-disk.component.css']
})
export class UpdateDiskComponent implements OnInit {

  id: string;
  disk: Disk;

  constructor(private route: ActivatedRoute,private router: Router,
              private diskService: DiskService) { }

  ngOnInit() {
    this.disk = new Disk();

    this.id = this.route.snapshot.params['id'];

    this.diskService.getDisk(this.id)
      .subscribe(data => {
        console.log(data)
        this.disk = data;
      }, error => console.log(error));
  }

  updateDisk() {
    this.diskService.updateDisk(this.id, this.disk)
      .subscribe(data => console.log(data), error => console.log(error));
    this.disk = new Disk();
    this.gotoList();
  }

  onSubmit() {
    this.updateDisk();
  }

  gotoList() {
    this.router.navigate(['/disks']);
  }
}
