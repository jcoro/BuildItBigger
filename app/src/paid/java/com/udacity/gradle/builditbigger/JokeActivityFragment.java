package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.JavaJoke;
import com.udacity.gradle.builditbigger.callbacks.AsyncTaskCompleteListener;

import net.coronite.gradle.androidlibrary.LibraryActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {
    private Button mToastButton;
    private Button mLibraryButton;
    private Button mEndpointButton;
    private ProgressBar mProgress;
    private Boolean mProgressBarShowing = false;


    public JokeActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retain this fragment across configuration changes.
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_joke, container, false);

        mProgress=(ProgressBar) root.findViewById(R.id.progressBar);

        if (!mProgressBarShowing) {
            mProgress.setVisibility(View.GONE);
        } else {
            mProgress.setVisibility(View.VISIBLE);
        }

        mToastButton = (Button) root.findViewById(R.id.toast_button);
        mToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        mLibraryButton = (Button) root.findViewById(R.id.android_library_button);
        mLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJokeFromAndroidLibrary();
            }
        });

        mEndpointButton = (Button) root.findViewById(R.id.android_endpoint_button);
        mEndpointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.setVisibility(View.VISIBLE);
                mProgressBarShowing = true;
                getJokeFromEndpoint();
            }
        });

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void tellJoke(){
        JavaJoke javaJoke = new JavaJoke();
        Toast.makeText(getActivity(), javaJoke.getJoke(), Toast.LENGTH_SHORT).show();
    }

    public void getJokeFromAndroidLibrary(){
        Intent myIntent = new Intent(getActivity(), LibraryActivity.class );
        JavaJoke javaJoke = new JavaJoke();
        String joke = javaJoke.getJoke();
        myIntent.putExtra(LibraryActivity.JOKE_KEY, joke);
        startActivity(myIntent);
    }

    public void getJokeFromEndpoint(){
        new EndpointsAsyncTask(new AsyncTaskCompleteListener<String>() {
            @Override
            public void onTaskComplete(String result)
            {
                if (result != null ) {
                    Intent myIntent = new Intent(getActivity(), LibraryActivity.class );
                    myIntent.putExtra(LibraryActivity.JOKE_KEY, result);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(getContext(), "No Result Returned", Toast.LENGTH_LONG).show();
                }
                mProgress.setVisibility(View.GONE);
                mProgressBarShowing = false;
            }
        }).execute();
    }

}

