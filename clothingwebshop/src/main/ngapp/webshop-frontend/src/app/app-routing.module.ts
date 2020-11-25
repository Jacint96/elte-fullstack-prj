import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {ProductComponent} from './product/product.component';
import {CartComponent} from './cart/cart.component';
import {AdminComponent} from './admin/admin.component';
import {ProductsComponent} from './admin/products/products.component';
import {UsersComponent} from './admin/users/users.component';
import {EditUserComponent} from './admin/users/edit-user/edit-user.component';
import {NewProductComponent} from './admin/products/new-product/new-product.component';
import {EditProductComponent} from './admin/products/edit-product/edit-product.component';

const routes: Routes = [
  {
    path: 'admin',
    component: AdminComponent
  },
  {
    path: 'admin/products',
    component: ProductsComponent
  },
  {
    path: 'admin/products/new',
    component: NewProductComponent
  },
  {
    path: 'admin/product/:id/edit',
    component: EditProductComponent
  },
  {
    path: 'admin/users',
    component: UsersComponent
  },
  {
    path: 'admin/user/:id/edit',
    component: EditUserComponent
  },
  {
    path: 'products',
    component: HomeComponent
  },
  {
    path: 'products/:id',
    component: ProductComponent
  },
  {
    path: 'cart',
    component: CartComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
