package com.nwmissouri.taxiapp;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;

import com.parse.*;
/**
 * Created by S525894 on 3/22/2017.
 */

public class StartParseServer extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("PeTfCQAQL7tnA8g89mF6qYnKgBppNWgBVEifWH1V")
                        .clientKey("HPgjcugXJqG3YiUkp7gXhTUGakbBkGRlkgMQqRrd")
                        .server("https://parseapi.back4app.com") // The trailing slash is important.
                        .build()
                //COmmit with this project
        );

        ParseUser parseUser = new ParseUser();
        parseUser.put("username","Sri");
        parseUser.saveInBackground();
        ParseObject parseObject = new ParseObject("Examples");
        parseObject.put("username","Srinu");
        parseObject.put("password","sri685");
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    Log.i("Parse Server","Successful");
                }else{
                    Log.i("Parse Server","UnSuccessful"+(e.getMessage()));
                }
            }
        });


    }
}
