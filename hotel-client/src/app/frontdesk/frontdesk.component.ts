import { Component, OnInit } from '@angular/core';
import { Checkout } from '../models/frontdesk/checkout';
import { FrontdeskService } from '../services/frontdesk.service';

@Component({
  selector: 'app-frontdesk',
  templateUrl: './frontdesk.component.html',
  styleUrls: ['./frontdesk.component.css']
})
export class FrontdeskComponent implements OnInit {
  
  query:string;
  checkout:Checkout={
    roomNumber:'',
    checkoutDate:'',
  }
  
  constructor(private frontDeskService:FrontdeskService){ }
  
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  submitQuery(){
    this.frontDeskService.handleQuery({query:this.query}).subscribe(response=>{
      console.log("query submittedm",response);
    })
  }

  submitCheckout(){
    this.frontDeskService.handleCheckout(this.checkout).subscribe(response=>{
      console.log("Checkout submitted",response);
    })
  }
}
