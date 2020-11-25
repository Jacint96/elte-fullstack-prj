import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css']
})
export class ProductGridComponent implements OnInit {

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
