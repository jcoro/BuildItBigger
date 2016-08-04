package net.coronite.gradle.androidlibrary;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class LibraryActivityFragment extends Fragment {
    String mJoke;

    public LibraryActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_library, container, false);
        Intent intent = getActivity().getIntent();
        mJoke = intent.getStringExtra(LibraryActivity.JOKE_KEY);
        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_library_text_view);
        if (mJoke != null && mJoke.length() != 0) {
            jokeTextView.setText(mJoke);
        }
        return root;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("jokeString", mJoke);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("jokeString")) {
            mJoke = savedInstanceState.getString("jokeString");
        }
    }
}
