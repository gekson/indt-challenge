import { DiskDetailsComponent } from '../disk-details/disk-details.component';
import { Observable } from "rxjs";
import { DiskService } from "../disk.service";
import { Disk } from "../disk";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-disk-list',
  templateUrl: './disk-list.component.html',
  styleUrls: ['./disk-list.component.css']
})
export class DiskListComponent implements OnInit {
  disks: Observable<Disk[]>;

  constructor(private diskService: DiskService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.disks = this.diskService.getDisksList();
  }

  deleteDisk(id: string) {
    this.diskService.deleteDisk(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  diskDetails(id: string){
    this.router.navigate(['details', id]);
  }

  diskEdit(id: string){
    this.router.navigate(['update', id]);
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }
}
