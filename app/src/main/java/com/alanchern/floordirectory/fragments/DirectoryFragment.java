package com.alanchern.floordirectory.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alanchern.floordirectory.MainActivity;
import com.alanchern.floordirectory.utils.DirectoryAdapter;
import com.alanchern.floordirectory.R;

/**
 * Created by alanchern on 1/15/17.
 */

public class DirectoryFragment extends Fragment {
    private static final int NUMBER_FLOORS = 9;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.directory_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        ((MainActivity) getActivity()).showBackButton();

        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.directory_recycler);
        recycler.setHasFixedSize(true);
        DirectoryAdapter adapter = new DirectoryAdapter(NUMBER_FLOORS);
        recycler.setAdapter(adapter);
    }
}
