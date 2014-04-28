package com.mike.app;

/**
 * Created by MichaelHenry on 4/21/14.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.mike.getlocation.GPSTracker;
import com.mike.utilimages.LazyImageLoadAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity2 extends Activity {

    public static final String mainURL = "http://view-unlimited.com/jsontest/weathertest";
    public static final String newURL = "http://view-unlimited.com/jsontest/myweatherjson";

    public static Context context;
    public static LazyImageLoadAdapter mLazyImageLoadAdapter;
    public static GridView mGridView;
    public static ArrayList<String> mArrayList;
    public static String urls;

    public String myLatitude;
    public String myLongitude;
    public String myCity;
    public String myAddressLine;
    public String myZipCode;
    public String myCountry;
    GPSTracker mGpsTracker;

    public TextView maxTempTV, minTempTV, feelsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLocation();

        context = this;

        mGridView = (GridView) findViewById(R.id.gridView);

        new LoadImageTask(context, newURL).execute();

    }

    public void getLocation() {

        mGpsTracker = new GPSTracker(this);
        if (mGpsTracker.canGetLocation()) {

            myLatitude = String.valueOf(mGpsTracker.latitude);
            System.out.println("LATITUDE : " + myLatitude);
            myLongitude = String.valueOf(mGpsTracker.longitude);
            System.out.println("LONGITUDE : " + myLongitude);

            myCountry = mGpsTracker.getCountryName(this);
            System.out.println("COUNTRY : " + myCountry);
            myCity = mGpsTracker.getLocality(this);
            System.out.println("CITY : " + myCity);

            myZipCode = mGpsTracker.getPostalCode(this);
            System.out.println("ZIP : " + myZipCode);
            myAddressLine = mGpsTracker.getAddressLine(this);
            System.out.println("ADDRESS : " + myAddressLine);

        } else {

            mGpsTracker.showSettingsAlert();
        }

    }

    /**
     * Created by MichaelHenry on 4/26/14.
     */
    public void LoadImages(String newURL) {

        mArrayList = new ArrayList<String>();

        try {

            JSONObject mainJSONObject = new JSONObject(loadJSON(newURL));
            JSONArray getDescription = mainJSONObject.getJSONObject("data").getJSONArray("weatherdata");
            Log.i("GET DESCRIPTION : ", getDescription.toString());

            if (getDescription != null) {

                for (int i = 0; i < getDescription.length(); i++) {

                    JSONObject Jobject = getDescription.getJSONObject(i);
                    if (Jobject != null) {

                        urls = Jobject.getString("weather_icon_day");
                        Log.i("URLS : ", urls);
                        mArrayList.add(urls);

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public String loadJSON(String someURL) {

        String json = null;
        HttpClient mHttpClient = new DefaultHttpClient();
        HttpGet mHttpGet = new HttpGet(someURL);

        try {

            HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
            StatusLine statusline = mHttpResponse.getStatusLine();
            int statusCode = statusline.getStatusCode();
            if (statusCode != 200) {

                return null;

            }
            InputStream jsonStream = mHttpResponse.getEntity().getContent();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(jsonStream));

            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                builder.append(line);

            }

            json = builder.toString();

        } catch (IOException ex) {

            ex.printStackTrace();

            return null;
        }
        mHttpClient.getConnectionManager().shutdown();
        return json;


    }

    /**
     * Created by MichaelHenry on 4/26/14.
     */
    public class LoadImageTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;
        Context context;
        String URL;

        public LoadImageTask(Context context, String URL) {

            super();
            this.context = context;
            this.URL = URL;


        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage("Loading files...");
            pDialog.setIndeterminate(true);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            LoadImages(URL);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            mLazyImageLoadAdapter = new LazyImageLoadAdapter(context, mArrayList);
            mGridView.setAdapter(mLazyImageLoadAdapter);
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

        switch (item.getItemId()) {

            case R.id.action_settings:
                mLazyImageLoadAdapter.imageLoader.clearCache();
                mLazyImageLoadAdapter.notifyDataSetChanged();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
