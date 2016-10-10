package com.sagarrathod.builditbigger;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.samsung.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by samsung on 01-Oct-2016.
 */

public class EndpointsAsyncTask extends AsyncTask<String,Void, String> {

    private final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private ResultCallbackListener resultCallbackListener;
    private ProgressBar mProgressBar;

    public EndpointsAsyncTask(ResultCallbackListener resultCallbackListener,
                              ProgressBar progressBar) {
        this.resultCallbackListener = resultCallbackListener;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... params) {
        String rootUrl = "https://tactile-acrobat-144517.appspot.com/_ah/api/";

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(rootUrl)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
        String name = params[0];
        try {
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String jokeText) {
        mProgressBar.setVisibility(View.GONE);
        resultCallbackListener.resultCallback(jokeText);
    }

}
