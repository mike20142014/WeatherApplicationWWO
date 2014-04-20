package com.mike.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.mike.models.EverydayWeatherModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
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

/**
 * Created by MichaelHenry on 4/15/14.
 */
public class HttpConnection {

    Context context;
    EverydayWeatherModel everydayWeatherModel;
    String mainURL;
    ArrayList<String> testURLs = new ArrayList<String>();

    public void HttpConnectionUTIL(String someURL) {


        everydayWeatherModel = new EverydayWeatherModel(context);

        try {

            JSONObject mainJSONObject = new JSONObject(loadJSONFromAsset(someURL));
            //JSONArray imageArray = mainJSONObject.getJSONObject("data").getJSONArray("weather");

            JSONArray getDescription = mainJSONObject.getJSONObject("data").getJSONArray("weather");
            //Log.i("Some Data : ", mainJSONObject.toString());

            if (getDescription != null) {

                for (int i = 0; i < getDescription.length(); i++) {

                    JSONObject object = getDescription.getJSONObject(i);
                    if (object != null) {

                        JSONArray hourlyArray = object.getJSONArray("hourly");
                        if (hourlyArray != null) {

                            for (int j = 0; j < hourlyArray.length(); j++) {

                                JSONObject innerElement = hourlyArray.getJSONObject(j);
                                if (innerElement != null) {

                                    JSONArray weatherICONarray = innerElement.getJSONArray("weatherIconUrl");
                                    if (weatherICONarray != null) {

                                        for (int k = 0; k < weatherICONarray.length(); k++) {

                                            JSONObject weatherJSONurls = weatherICONarray.getJSONObject(k);
                                            if (weatherJSONurls != null) {

                                                mainURL = weatherJSONurls.getString("value");

                                                everydayWeatherModel.setEverydayWeatherICON(mainURL);
                                                //testURLs.add(everydayWeatherModel.getEverydayWeatherICON());
                                                Log.i("iconURL", mainURL);
                                                Log.i("ICON URLS ARRAY", String.valueOf(everydayWeatherModel.getEverydayWeatherICON()));


                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }
                }
                //Log.i("ArrayList URLS : ", String.valueOf(testURLs));

            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    public String loadJSONFromAsset(String someURL) {

        String json = null;
        HttpClient mHttpClient = new DefaultHttpClient();
        HttpGet mHttpGet = new HttpGet(someURL);

        try {

            HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
            StatusLine statusline = mHttpResponse.getStatusLine();
            int statuscode = statusline.getStatusCode();
            if (statuscode != 200) {

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

    public boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        boolean isConnected = ni != null && ni.isConnectedOrConnecting();
        NetworkInfo niWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        /*if (ni == null&&niWifi==null) {
            // There are no active networks.
            Toast.makeText(context, "No Network", Toast.LENGTH_LONG).show();
            return false;
        } else
            return true;*/
        if (isConnected) {

            return true;

        } else {
            Toast.makeText(context, "No Network", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public boolean haveNetworkConnection(Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public boolean isDataEnabled(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return true;
    }

    //Downloading some images
    public Bitmap downloadBitmap(String url) {
        // initilize the default HTTP client object
        final DefaultHttpClient client = new DefaultHttpClient();

        //forming a HttoGet request
        final HttpGet getRequest = new HttpGet(url);
        try {

            HttpResponse response = client.execute(getRequest);

            //check 200 OK for success
            final int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode != HttpStatus.SC_OK) {
                Log.w("ImageDownloader", "Error " + statusCode +
                        " while retrieving bitmap from " + url);
                return null;

            }

            final HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream inputStream = null;
                try {
                    // getting contents from the stream
                    inputStream = entity.getContent();

                    // decoding stream data back into image Bitmap that android understands
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    return bitmap;
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    entity.consumeContent();
                }
            }
        } catch (Exception e) {
            // You Could provide a more explicit error message for IOException
            getRequest.abort();
            Log.e("ImageDownloader", "Something went wrong while" +
                    " retrieving bitmap from " + url + e.toString());
        }

        return null;

    }

}
