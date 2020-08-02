import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { DisplayCandidatesComponent } from './display-candidates/display-candidates.component';
import { AppRoutingModuleModule } from './app-routing-module/app-routing-module.module';
import { VoteComponent } from './vote/vote.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    DisplayCandidatesComponent,
    VoteComponent
  ],
  imports: [
    BrowserModule, AppRoutingModuleModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
