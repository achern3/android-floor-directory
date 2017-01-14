package com.alanchern.floordirectory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alanchern on 1/12/17.
 */

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.UnitViewHolder> {
    private ArrayList<Unit> mUnitList;

    public UnitAdapter(ArrayList<Unit> unitList) {
        mUnitList = unitList;
    }

    @Override
    public UnitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.unit_view_holder, null);
        return new UnitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UnitViewHolder holder, int position) {
        holder.bind(mUnitList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUnitList.size();
    }

    class UnitViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private TextView mUnitFloorText;
        private TextView mUnitNumberText;
        private TextView mUnitNameText;
        private Button mDetailButton;

        UnitViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();

            mUnitFloorText = (TextView) itemView.findViewById(R.id.unit_content1);
            mUnitNumberText = (TextView) itemView.findViewById(R.id.unit_content2);
            mUnitNameText = (TextView) itemView.findViewById(R.id.unit_title);
            mDetailButton = (Button) itemView.findViewById(R.id.unit_button);
        }

        void bind(final Unit unit) {
            if (unit != null) {
                mUnitFloorText.setText(String.valueOf(unit.getFloor()));
                mUnitNumberText.setText(unit.getUnitNumber());
                mUnitNameText.setText(unit.getUnitName());
                mDetailButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity) mContext).showUnitDetail(unit);
                    }
                });
            }
        }
    }
}
