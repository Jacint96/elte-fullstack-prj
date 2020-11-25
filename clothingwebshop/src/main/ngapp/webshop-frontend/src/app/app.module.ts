import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCarouselModule } from '@ngmodule/material-carousel';
import { MatCardModule } from '@angular/material/card';

import { AppRoutingModule } from './app-routing.module';
import { AuthModule } from './auth/auth.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ProductComponent } from './product/product.component';
import { BannerComponent } from './banner/banner.component';
import { FooterComponent } from './footer/footer.component';

import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductGridComponent } from './product-grid/product-grid.component';
import { FeatureSliderComponent } from './feature-slider/feature-slider.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CartComponent } from './cart/cart.component';
import { AdminComponent } from './admin/admin.component';
import { ProductsComponent } from './admin/products/products.component';
import { UsersComponent } from './admin/users/users.component';
import { NewUserComponent } from './admin/users/new-user/new-user.component';
import { EditUserComponent } from './admin/users/edit-user/edit-user.component';
import { NewProductComponent } from './admin/products/new-product/new-product.component';
import { EditProductComponent } from './admin/products/edit-product/edit-product.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    BannerComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    ProductGridComponent,
    FeatureSliderComponent,
    CartComponent,
    AdminComponent,
    ProductsComponent,
    UsersComponent,
    NewUserComponent,
    EditUserComponent,
    NewProductComponent,
    EditProductComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatCarouselModule.forRoot(),
    MatCardModule,
    AuthModule,
    RouterModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
