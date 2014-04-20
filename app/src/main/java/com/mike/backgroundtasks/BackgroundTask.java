/*
package com.mike.backgroundtasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.mike.app.MainActivity;
import com.mike.utils.HttpConnection;

*/
/**
 * Created by MichaelHenry on 4/15/14.
 *//*

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
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        mHttpConnection = new HttpConnection();
        mainContext = new MainActivity();
        mainContext.getCurrentCondition(SomeURL);
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
        pDialog.dismiss();
    }

}


*/
