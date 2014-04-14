package com.mike.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Created by MichaelHenry on 4/14/14.
 */
public class MainActivity extends ActionBarActivity {

    public static final String MainURL = "http://api.worldweatheronline.com/free/v1/weather.ashx?q=London&format=json&num_of_days=5&key=8ecy7xxhuk7ydj2hqp6wstuy";
    public static final String FirstPart = "http://api.worldweatheronline.com/free/v1/weather.ashx?";
    public static String SecondPart = "q=";
    public static String ThirdPartCityName = "London";
    public static final String FourthPartFormat = "&format=json";
    public static final String FifthPart = "&num_of_days=";
    public static String SixthPartForecastCount = "5";
    public static final String SeventhPartApiKey = "8ecy7xxhuk7ydj2hqp6wstuy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
