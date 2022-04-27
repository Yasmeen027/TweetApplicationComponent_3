import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { ValidateEqualModule } from 'ng-validate-equal';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LogoutComponent } from './logout/logout.component';
import { ForgetComponent } from './forget/forget.component';
import { PostTweetComponent } from './Tweet/post-tweet/post-tweet.component';
import { TweetMainComponent } from './Tweet/tweet-main/tweet-main.component';
import { ShowMyTwwetComponent } from './Tweet/show-my-tweet/show-my-twwet.component';
import { ShowAllTweetComponent } from './Tweet/show-all-tweet/show-all-tweet.component';
import { ViewAllUsersComponent } from './Tweet/view-all-users/view-all-users.component';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './Tweet/user-profile/user-profile.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    LogoutComponent,
    ForgetComponent,
    PostTweetComponent,
     TweetMainComponent,
    ShowMyTwwetComponent,
    ViewAllUsersComponent,
    ShowAllTweetComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    ValidateEqualModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
