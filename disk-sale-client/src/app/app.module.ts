import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateDiskComponent } from './create-disk/create-disk.component';
import { DiskDetailsComponent } from './disk-details/disk-details.component';
import { DiskListComponent } from './disk-list/disk-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateDiskComponent,
    DiskDetailsComponent,
    DiskListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
