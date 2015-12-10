package com.example.ibra.parsetutorials;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by ibra on 12/8/15.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "tR4G5zUyepIcr3vUCZVTgBMDFxczAG887SoXGdZ9", "Wbq00XhDe7SEUshirX5AOQmvDe3by5gv5U5FbgHO");

        ParseObject gameScore = new ParseObject("GameScore");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground();

    }
}
