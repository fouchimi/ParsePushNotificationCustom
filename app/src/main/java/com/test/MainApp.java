package com.test;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.interceptors.ParseLogInterceptor;
import com.parse.interceptors.ParseStethoInterceptor;

import android.app.Application;

public class MainApp extends Application {

    private static final String PARSE_APP_ID = "azToMN4wUXwefx3ISIxrZckE";
    private static final String PARSE_CLOUD_SERVER_URL = "http://parsepushdemo.herokuapp.com/parse/";

    // Make sure to update gcm_sender_id in strings.xml!!

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(PARSE_APP_ID)
                .clientKey(null) // no client key needed in Parse open source
                .server(PARSE_CLOUD_SERVER_URL) // do not forget the URL needs to end with a trailing slash
                .addNetworkInterceptor(new ParseStethoInterceptor())
                .addNetworkInterceptor(new ParseLogInterceptor())
                .build());

        // Need to register GCM token
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
