import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

export class ProductComponent implements OnInit {
  products = [];
  product;
  id = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.products = [ {id : 0, name : '', image : '', description : ''},
                      {id : 1, name : 'Ing', image : '/assets/images/products/product1.jpg', description : 'Láthatatlanná tevő ing'},
                      {id : 2, name: 'Sweater', image : '/assets/images/products/product2.jpg', description : 'Lacoste sweater'},
                      {id : 3, name : 'Blazer', image : '/assets/images/products/product3.jpg', description : 'Batman\'s blazer'},
                      {id : 4, name : 'Felső', image : '/assets/images/products/product4.jpg', description : 'Average felső'},
    ];
    this.id = this.route.snapshot.paramMap.get('id');
  }

}
