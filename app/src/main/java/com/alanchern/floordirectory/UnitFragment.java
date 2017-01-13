package com.alanchern.floordirectory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by alanchern on 1/12/17.
 */

public class UnitFragment extends Fragment {
    private static final String UNIT_LIST_KEY = "unit_list_key";

    public static UnitFragment newInstance(ArrayList<Unit> unitList) {
        UnitFragment unitFragment = new UnitFragment();
        Bundle bundle = new Bundle();
        // bundle.putSerializable(UNIT_LIST_KEY, unitList);
        bundle.putParcelableArrayList(UNIT_LIST_KEY, unitList);
        unitFragment.setArguments(bundle);
        return unitFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = View.inflate(getActivity(), R.layout.unit_fragment, null);
        init(view);
        return view;
    }

    private void init(View view) {
        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.unit_recycler);
        ArrayList<Unit> unitList = getArguments().getParcelableArrayList(UNIT_LIST_KEY);
        if (unitList != null) {
            UnitAdapter adapter = new UnitAdapter(unitList);
            recycler.setHasFixedSize(true);
            recycler.setAdapter(adapter);
        }
    }
}
