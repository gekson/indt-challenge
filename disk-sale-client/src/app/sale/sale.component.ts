import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { SaleService } from "../sale.service";
import { Sale } from "../sale";
import { Router } from '@angular/router';
import { Chart } from 'angular-highcharts';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {
  sales: Observable<Sale[]>;

  loading = true;
  ChartModule: any;
  chartOptions: any;

  constructor(private saleService: SaleService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
    this.saleService.getSalesList()
      .pipe()
      .subscribe(
        data => {
          // this.chartOptions.series = [{
          //     data: data
          // }];
          this.ChartModule = Chart;
          this.chartOptions = {
            chart: {
              type: 'column'
            },
            title: {
              text: 'Stacked column chart'
            },
            xAxis: {
              categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
            },
            series: data.data
          };
          this.loading = false;
        },
        () => { });
  }

  reloadData() {
    this.sales = this.saleService.getSalesList();
  }

}
