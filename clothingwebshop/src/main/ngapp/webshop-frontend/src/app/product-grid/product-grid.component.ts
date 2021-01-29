import { Component, OnInit } from '@angular/core';
import { ProductsService} from '../products.service';
import { Product} from '../product/product';


@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css']
})
export class ProductGridComponent implements OnInit {

  constructor(private productsService: ProductsService) { }
  products = [];
  productgrid: Product[];

  async ngOnInit(): Promise<void> {
    this.productgrid = await this.productsService.getProducts();
  }

}
