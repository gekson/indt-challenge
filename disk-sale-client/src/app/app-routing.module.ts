import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { DiskListComponent } from './disk-list/disk-list.component';
import { AuthGuard } from './auth/auth.guard';
import { DiskDetailsComponent } from './disk-details/disk-details.component';
import { CreateDiskComponent } from './create-disk/create-disk.component';
import { UpdateDiskComponent } from './update-disk/update-disk.component';

const routes: Routes = [
  {
    path: 'disks',
    canActivate: [AuthGuard],
    component: DiskListComponent,
    data: { title: 'List of Disks' }
  },
  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'Login' }
  },
  {
    path: 'register',
    component: RegisterComponent,
    data: { title: 'Register' }
  },
  {
    path: 'add',
    canActivate: [AuthGuard],
    component: CreateDiskComponent
  },
  {
    path: 'update/:id',
    canActivate: [AuthGuard],
    component: UpdateDiskComponent
  },
  {
    path: 'details/:id',
    canActivate: [AuthGuard],
    component: DiskDetailsComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
