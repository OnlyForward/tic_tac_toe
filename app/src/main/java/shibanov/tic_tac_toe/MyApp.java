package shibanov.tic_tac_toe;

import android.app.Application;

import shibanov.tic_tac_toe.model.DbOpenHelper;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this, "tic_tac-db");
 //       TakeDb.setDbOpenHelper(dbOpenHelper);
    }
}
