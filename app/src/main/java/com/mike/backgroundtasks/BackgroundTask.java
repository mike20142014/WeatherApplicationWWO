package com.mike.backgroundtasks;

import android.os.AsyncTask;

import com.mike.utils.HttpConnection;

/**
 * Created by MichaelHenry on 4/15/14.
 */
public class BackgroundTask extends AsyncTask<Void, Void, Void> {
    String SomeURL;
    HttpConnection mHttpConnection;

    public BackgroundTask(String someURL) {

        super();
        this.SomeURL = someURL;

    }

    @Override
    protected Void doInBackground(Void... params) {

        mHttpConnection = new HttpConnection();
        mHttpConnection.HttpConnectionUTIL(SomeURL);
        //return downloadBitmap(SomeURL);
        return null;
    }

}
