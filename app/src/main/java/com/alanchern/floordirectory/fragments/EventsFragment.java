package com.alanchern.floordirectory.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alanchern.floordirectory.MainActivity;
import com.alanchern.floordirectory.R;

/**
 * Created by alanchern on 1/15/17.
 */

public class EventsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.events_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        // init code
    }
}
