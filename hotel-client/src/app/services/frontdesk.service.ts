import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http"
import { Observable } from 'rxjs';
import { Checkout } from '../models/frontdesk/checkout';
import { Custquery } from '../models/frontdesk/custquery';

@Injectable({
  providedIn: 'root'
})
export class FrontdeskService {

  constructor(private http:HttpClient) { }

  handleQuery(query:Custquery):Observable<any>{
    return this.http.post<any>('{backend_host}/frontdesk/query',query);
  }

  handleCheckout(checkout:Checkout):Observable<any>{
    return this.http.post<any>('{backjend_host}/frontdesk/checkout',checkout);
  }
}
