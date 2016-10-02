package com.sagarrathod.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.samsung.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.sagarrathod.andlib.DisplayActivity;
import com.sagarrathod.commons.Utils;

import java.io.IOException;

/**
 * Created by samsung on 01-Oct-2016.
 */

public class EndpointsAsyncTask extends AsyncTask<String,Void, String> {

    private static MyApi myApiService = null;
    private Context mContext;

    public EndpointsAsyncTask(Context context){
        this.mContext = context;
    }

    @Override
    protected String doInBackground(String... params) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://tactile-acrobat-144517.appspot.com/_ah/api/")
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

        Intent intent = new Intent(mContext, DisplayActivity.class);
        intent.putExtra(Utils.INTENT_JOKE_EXTRA, jokeText);
        mContext.startActivity(intent);

    }
}
