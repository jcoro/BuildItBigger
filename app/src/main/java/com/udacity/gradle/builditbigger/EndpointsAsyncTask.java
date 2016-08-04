package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.john.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.callbacks.AsyncTaskCompleteListener;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private AsyncTaskCompleteListener<String> mListener;

    public EndpointsAsyncTask(AsyncTaskCompleteListener<String> listener) {
        mListener = listener;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jcbuilditbigger.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.getJokeEndpoint().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        // sends the result to JokeActivityFragment.FetchJokeCompleteListener.onTaskComplete.
        mListener.onTaskComplete(result);

    }
}
