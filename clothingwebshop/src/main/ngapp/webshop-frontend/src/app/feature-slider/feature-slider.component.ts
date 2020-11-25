import { Component, OnInit } from '@angular/core';
import { MatCarousel, MatCarouselComponent } from '@ngmodule/material-carousel';

@Component({
  selector: 'app-feature-slider',
  templateUrl: './feature-slider.component.html',
  styleUrls: ['./feature-slider.component.css']
})
export class FeatureSliderComponent implements OnInit {
  constructor() { }
  slides = [{ image: '/assets/images/cover/cover1.jpg' },
            { image: '/assets/images/cover/cover2.jpg' },
            { image: '/assets/images/cover/cover3.jpg' }];
  ngOnInit(): void {
  }
}
