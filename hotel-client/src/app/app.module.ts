import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingComponent } from './booking/booking.component';
import { FrontdeskComponent } from './frontdesk/frontdesk.component';
import { HousekeepingComponent } from './housekeeping/housekeeping.component';
import { KitchenComponent } from './kitchen/kitchen.component';

import { FrontdeskService } from './services/frontdesk.service';

@NgModule({
  declarations: [
    AppComponent,
    BookingComponent,
    FrontdeskComponent,
    HousekeepingComponent,
    KitchenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [FrontdeskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
