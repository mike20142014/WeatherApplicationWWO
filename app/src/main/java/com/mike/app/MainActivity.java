package com.mike.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mike.models.CurrentConditionModel;
import com.mike.models.EverydayWeatherModel;
import com.mike.utilimages.ImageLoader;
import com.mike.utils.HttpConnection;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by MichaelHenry on 4/14/14.
 */
public class MainActivity extends Activity {

    public static final String MainURL = "http://api.worldweatheronline.com/free/v1/weather.ashx?q=London&format=json&num_of_days=5&key=8ecy7xxhuk7ydj2hqp6wstuy";
    public static final String FirstPart = "http://api.worldweatheronline.com/free/v1/weather.ashx?";
    public static String SecondPart = "q=";
    public static String ThirdPartCityName = "London";
    public static final String FourthPartFormat = "&format=json";
    public static final String FifthPart = "&num_of_days=";
    public static String SixthPartForecastCount = "5";
    public static final String SeventhPartApiKey = "8ecy7xxhuk7ydj2hqp6wstuy";

    public TextView Feels_Like, Temp_F, Wind_Speed, Observation_Time, Humidity, Wind_Direction, Weather_Description;
    public ImageView weatherImage;
    public LinearLayout someBack;

    public String feelsLike;
    public String temp_F;
    public String windSpeed;
    public String observationTime;
    public String humidity;
    public String windDirection;
    public String weather_description;
    public String mainWeatherURL;

    String data;
    ImageLoader imageLoader;

    public static final String myDomainURL = "http://view-unlimited.com/jsontest/weatherjson";
    Context context;
    HttpConnection mHttpConnection;
    EverydayWeatherModel everydayWeatherModel;
    CurrentConditionModel currentConditionModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_conditions);
        context = this;

        init();

        everydayWeatherModel = new EverydayWeatherModel(context);
        currentConditionModel = new CurrentConditionModel(context);
        //new BackgroundTask(this,myDomainURL).execute();

        mHttpConnection = new HttpConnection();
        if (mHttpConnection.isNetworkConnected(context)) {

            Log.i("IS NETWORK : ", "YES");
            new BackgroundTask(this, myDomainURL).execute();

        } else {


            Log.i("IS NETWORK : ", "NO");
            return;

        }


    }

    public void init() {

        Feels_Like = (TextView) findViewById(R.id.feelslikeTextView);
        Temp_F = (TextView) findViewById(R.id.hightempTextView);
        Wind_Speed = (TextView) findViewById(R.id.windspeedTextView);
        Observation_Time = (TextView) findViewById(R.id.observationTimeTextView);
        Humidity = (TextView) findViewById(R.id.humidityTextView);
        Wind_Direction = (TextView) findViewById(R.id.winddirectionTextView);
        Weather_Description = (TextView) findViewById(R.id.descriptionTextView);
        weatherImage = (ImageView) findViewById(R.id.current_weatherIconImageView);
        someBack = (LinearLayout) findViewById(R.id.someBackground);

    }


    public void savePreviousValues() {

        SharedPreferences prefs = getSharedPreferences("your_file_name", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("feels_like", currentConditionModel.getFeelsLike());
        editor.putString("temp_f", currentConditionModel.getTemp());
        editor.putString("wind_speed", currentConditionModel.getWindSpeed());
        editor.putString("wind_direction", currentConditionModel.getWindDirection());
        editor.putString("observation_time", currentConditionModel.getObservationTime());
        editor.putString("weather_description", currentConditionModel.getValue());
        editor.putString("humidity", currentConditionModel.getHumidity());
        editor.commit();

    }

    public void restorePreviousValues() {

        SharedPreferences mPreferences = getSharedPreferences("your_file_name", Context.MODE_PRIVATE);
        String feels_like = null;
        String temp_f = null;
        String wind_speed = null;
        String wind_direction = null;
        String observation_time = null;
        String weather_description = null;
        String humidity = null;
        if (mPreferences.getBoolean("firstrun", true)) {
            mPreferences.edit().putBoolean("firstrun", false).commit();
        } else {

            feels_like = mPreferences.getString("feels_like", feels_like);
            temp_f = mPreferences.getString("temp_f", temp_f);
            wind_speed = mPreferences.getString("wind_speed", wind_speed);
            wind_direction = mPreferences.getString("wind_direction", wind_direction);
            observation_time = mPreferences.getString("observation_time", observation_time);
            weather_description = mPreferences.getString("weather_description", weather_description);
            humidity = mPreferences.getString("humidity", humidity);

            Feels_Like.setText(feels_like + "°F");
            Temp_F.setText(temp_f + "°F");
            Wind_Speed.setText(wind_speed + " mph ");
            Observation_Time.setText(observation_time);
            Humidity.setText(humidity + "%");
            Wind_Direction.setText(wind_direction);
            Weather_Description.setText(weather_description);

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        savePreviousValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restorePreviousValues();
    }

    public void setValuestoViews() {

        Feels_Like.setText(currentConditionModel.getFeelsLike() + "°F");
        Temp_F.setText(currentConditionModel.getTemp() + "°F");
        Wind_Speed.setText(currentConditionModel.getWindSpeed() + " mph ");
        Observation_Time.setText(currentConditionModel.getObservationTime());
        Humidity.setText(currentConditionModel.getHumidity() + "%");
        Wind_Direction.setText(currentConditionModel.getWindDirection());
        Weather_Description.setText(currentConditionModel.getValue());
        //weatherImage.setImageBitmap();

    }

    public void getCurrentCondition(String weatherURL) {

        if (mHttpConnection.isNetworkConnected(context)) {

            try {
                JSONObject mainJSONObject = new JSONObject(mHttpConnection.loadJSONFromAsset(weatherURL));
                JSONArray weatherJSONOArray = mainJSONObject.getJSONObject("data").getJSONArray("current_condition");
                if (weatherJSONOArray != null) {

                    for (int i = 0; i < weatherJSONOArray.length(); i++) {

                        JSONObject jsonObject = weatherJSONOArray.getJSONObject(i);

                        if (jsonObject != null) {

                            feelsLike = jsonObject.getString("FeelsLikeF");
                            //everydayWeatherModel.setEverydayFeelsLike(feelsLike);
                            currentConditionModel.setFeelsLike(feelsLike);
                            Log.i("Feels Like : ", feelsLike);
                            temp_F = jsonObject.getString("temp_F");
                            //everydayWeatherModel.setEverydayTempF(temp_F);
                            currentConditionModel.setTemp(temp_F);
                            Log.i("Temp F : ", temp_F);
                            windSpeed = jsonObject.getString("windspeedMiles");
                            //everydayWeatherModel.setEverydayWindSpeed(windSpeed);
                            currentConditionModel.setWindSpeed(windSpeed);
                            Log.i("Wind Speed : ", windSpeed);
                            observationTime = jsonObject.getString("observation_time");
                            currentConditionModel.setObservationTime(observationTime);
                            Log.i("Observation Time : ", observationTime);
                            humidity = jsonObject.getString("humidity");
                            currentConditionModel.setHumidity(humidity);
                            Log.i("Humidity : ", humidity);
                            windDirection = jsonObject.getString("winddir16Point");
                            currentConditionModel.setWindDirection(windDirection);
                            Log.i("Wind Direction : ", windDirection);


                            JSONArray descriptionArray = jsonObject.getJSONArray("weatherDesc");


                            //Get weather Description
                            for (int j = 0; j < descriptionArray.length(); j++) {

                                JSONObject descriptionObject = descriptionArray.getJSONObject(j);

                                if (descriptionObject != null) {
                                    weather_description = descriptionObject.getString("value");
                                    currentConditionModel.setValue(weather_description);
                                    Log.i("Weather Description : ", weather_description);
                                }

                            }

                            //Get weather URL
                            JSONArray weatherURLArray = jsonObject.getJSONArray("weatherIconUrl");
                            for (int k = 0; k < weatherJSONOArray.length(); k++) {

                                JSONObject weatherURLobject = weatherURLArray.getJSONObject(k);
                                if (weatherJSONOArray != null) {
                                    mainWeatherURL = weatherURLobject.getString("value");
                                    Log.i("Weather URl : ", mainWeatherURL);
                                }

                            }

                        }

                    }

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        } else {

            Toast.makeText(context, "No Internet connection", Toast.LENGTH_LONG).show();

        }
    }

    public void getHourlyForecast(String weatherURL) {

        try {
            JSONObject mainJSONObject = new JSONObject(mHttpConnection.loadJSONFromAsset(weatherURL));
            JSONArray weatherJSONOArray = mainJSONObject.getJSONObject("data").getJSONArray("current_condition");
            if (weatherJSONOArray != null) {

                for (int i = 0; i < weatherJSONOArray.length(); i++) {
                    JSONObject object = weatherJSONOArray.getJSONObject(i);
                    if (object != null) {
                        JSONArray hourlyArray = object.getJSONArray("hourly");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Created by MichaelHenry on 4/15/14.
     */
    public class BackgroundTask extends AsyncTask<String, String, String> {
        String SomeURL;
        HttpConnection mHttpConnection;
        ProgressDialog pDialog;
        Context mContext;
        private int mProgressStatus = 0;
        MainActivity mainContext;

        public BackgroundTask() {
        }

        public BackgroundTask(Context mContext, String someURL) {

            super();
            this.mContext = mContext;
            this.SomeURL = someURL;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(mContext);
            pDialog.setMessage("Loading files...");
            pDialog.setIndeterminate(true);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            mHttpConnection = new HttpConnection();
            getCurrentCondition(SomeURL);
            //mHttpConnection.HttpConnectionUTIL(SomeURL);
            //return downloadBitmap(SomeURL);

            return null;
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            setValuestoViews();
            imageLoader = new ImageLoader(context);
            imageLoader.DisplayImage(mainWeatherURL, R.drawable.ic_launcher, weatherImage);
            imageLoader.DisplayImage2(context, mainWeatherURL, R.drawable.ic_launcher, someBack);


            pDialog.dismiss();
        }

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
