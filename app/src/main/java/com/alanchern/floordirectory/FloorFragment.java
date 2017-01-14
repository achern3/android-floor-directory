package com.alanchern.floordirectory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alanchern on 1/13/17.
 */

public class FloorFragment extends Fragment {
    private static final String NUMBER_FLOOR_KEY = "number_floor_key";

    public static FloorFragment newInstance(int numberFloors) {
        FloorFragment floorFragment = new FloorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NUMBER_FLOOR_KEY, numberFloors);
        floorFragment.setArguments(bundle);
        return floorFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = View.inflate(getActivity(), R.layout.floor_fragment, null);
        init(view);
        return view;
    }

    private void init(View view) {
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.floor_recycler);
        recycler.setHasFixedSize(true);
        int numberFloors = getArguments().getInt(NUMBER_FLOOR_KEY);
        FloorAdapter floorAdapter = new FloorAdapter(numberFloors);
        recycler.setAdapter(floorAdapter);
    }
}
