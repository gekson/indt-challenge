import { Disk } from '../disk';
import { Component, OnInit, Input } from '@angular/core';
import { DiskService } from '../disk.service';
import { DiskListComponent } from '../disk-list/disk-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-disk-details',
  templateUrl: './disk-details.component.html',
  styleUrls: ['./disk-details.component.css']
})
export class DiskDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['disks']);
  }
}
