package com.mike.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by MichaelHenry on 4/15/14.
 */
public class HttpConnection {

    public void HttpConnectionUTIL(String someURL) {

        HttpClient mHttpClient = new DefaultHttpClient();
        HttpGet mHttpGet = new HttpGet(someURL);

        try {

            HttpResponse mHttpResponse = mHttpClient.execute(mHttpGet);
            StatusLine statusline = mHttpResponse.getStatusLine();
            int statuscode = statusline.getStatusCode();
            if (statuscode != 200) {

                return;

            }
            InputStream jsonStream = mHttpResponse.getEntity().getContent();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(jsonStream));

            StringBuilder builder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                builder.append(line);

            }

            String _response = builder.toString();
            JSONObject mainJSONObject = new JSONObject(_response);
            Log.i("Some Data : ", mainJSONObject.toString());

        } catch (Exception e) {

            e.printStackTrace();

        }

        mHttpClient.getConnectionManager().shutdown();

    }

    //Downloading some images
    private Bitmap downloadBitmap(String url) {
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
