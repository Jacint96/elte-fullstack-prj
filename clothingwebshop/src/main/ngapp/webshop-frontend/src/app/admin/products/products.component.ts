import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor() { }
  products = [];
  ngOnInit(): void {
    this.products = [ {id : 1, name : 'Ing', image : '/assets/images/products/product1.jpg', description : 'Láthatatlanná tevő ing'},
      {id : 2, name: 'Sweater', image : '/assets/images/products/product2.jpg', description : 'Lacoste sweater'},
      {id : 3, name : 'Blazer', image : '/assets/images/products/product3.jpg', description : 'Batman\'s blazer'},
      {id : 4, name : 'Felső', image : '/assets/images/products/product4.jpg', description : 'Average felső'},
    ];
  }

}
