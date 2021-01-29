import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product/product';

const axiosConfig = {
  headers: {
    Authorization: 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0VXNlcjIiLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiZXhwIjoxNjExOTMzNDEwLCJpYXQiOjE2MTE5MzE2MTB9.nKgtETFtDkPnlPwOO-n7_eQIT1lZEErPYU7ragwbKwOFAxZmFwdiLsFJUHDxEp02jQ5J2qnAnlJBAEf4hjQR1w'
  },
  credentials: 'same-origin'
};

@Injectable({
  providedIn: 'root'
})

export class ProductsService {
  private baseUrl = 'https://clothingwebshop.herokuapp.com/products';
  constructor(private http: HttpClient) { }
  async getProducts(): Promise<Product[]>{
    const products = await this.http
      .get<Product[]>(`${this.baseUrl}`, axiosConfig)
      .toPromise();
    return products;
  }
  async getProduct(productId: number): Promise<Product> {
    const product = await this.http
      .get<Product>(`https://clothingwebshop.herokuapp.com/products/${productId}`)
      .toPromise();
    return product;
  }
}
