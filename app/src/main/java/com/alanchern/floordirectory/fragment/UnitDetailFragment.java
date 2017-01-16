package com.alanchern.floordirectory.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alanchern.floordirectory.MainActivity;
import com.alanchern.floordirectory.R;
import com.alanchern.floordirectory.model.Unit;

/**
 * Created by alanchern on 1/13/17.
 */

public class UnitDetailFragment extends Fragment {
    private static final String UNIT_KEY = "unit_key";

    public static UnitDetailFragment newInstance(Unit unit) {
        UnitDetailFragment unitDetailFragment = new UnitDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(UNIT_KEY, unit);
        unitDetailFragment.setArguments(bundle);
        return unitDetailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.unit_detail_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        // ((MainActivity) getActivity()).showBackButton();

        Bundle bundle = getArguments();
        if (bundle != null) {
            Unit unit = bundle.getParcelable(UNIT_KEY);
            if (unit != null) {
                int floor = unit.getFloor();
                String unitNumber = unit.getUnitNumber();
                String unitName = unit.getUnitName();

                TextView unitTitleText = (TextView) view.findViewById(R.id.unit_title);
                unitTitleText.setText(unitName);
                TextView floorText = (TextView) view.findViewById(R.id.unit_content1);
                floorText.setText(String.valueOf(floor));
                TextView unitNumberText = (TextView) view.findViewById(R.id.unit_content2);
                unitNumberText.setText(unitNumber);
            }
        }
    }
}
