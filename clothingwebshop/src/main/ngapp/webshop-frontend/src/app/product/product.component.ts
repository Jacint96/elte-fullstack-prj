import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService} from '../products.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

export class ProductComponent implements OnInit {
  product;

  constructor(private route: ActivatedRoute, private productsService: ProductsService) {}

  async ngOnInit(): Promise<void> {
    if (!this.product){
      const productId = parseInt(this.route.snapshot.paramMap.get('id'), 10);
      this.product = await this.productsService.getProduct(productId);
    }
  }

}
