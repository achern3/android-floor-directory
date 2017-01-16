package com.alanchern.floordirectory.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.alanchern.floordirectory.MainActivity;
import com.alanchern.floordirectory.R;
import com.alanchern.floordirectory.model.Floor;
import com.alanchern.floordirectory.model.Unit;

import java.util.ArrayList;

/**
 * Created by alanchern on 1/15/17.
 */

public class DirectoryAdapter extends RecyclerView.Adapter<DirectoryAdapter.DirectoryViewHolder> {
    private int mNumberFloors;

    public DirectoryAdapter(int numberFloors) {
        mNumberFloors = numberFloors;
    }

    @Override
    public DirectoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.directory_view_holder, null);
        return new DirectoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DirectoryViewHolder holder, int position) {
        holder.bind(position + 1);
    }

    @Override
    public int getItemCount() {
        return mNumberFloors;
    }

    class DirectoryViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private TextView mFloorText;
        private TableLayout mTableLayout;

        DirectoryViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();
            mFloorText = (TextView) itemView.findViewById(R.id.floor_text);
            mTableLayout = (TableLayout) itemView.findViewById(R.id.directory_table_layout);
        }

        void bind(int floor) {
            setFloorText(floor);

            ArrayList<Unit> list = Floor.getUnits(floor);
            for (final Unit unit : list) {
                TableRow row = new TableRow(mContext);
                View view = View.inflate(mContext, R.layout.unit_table_row, null);
                TextView unitNameText = (TextView) view.findViewById(R.id.unit_name_text);
                unitNameText.setText(unit.getUnitName());
                TextView unitContactInfoText = (TextView) view.findViewById(R.id.unit_contact_info_text);
                unitContactInfoText.setText(unit.getUnitContactNumber());
                TextView unitDescriptionText = (TextView) view.findViewById(R.id.unit_description_text);
                unitDescriptionText.setText(unit.getUnitDescription());
                Button detailButton = (Button) view.findViewById(R.id.unit_detail_button);
                detailButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity) mContext).showUnitDetail(unit);
                    }
                });
                row.addView(view);
                mTableLayout.addView(row);
            }
        }

        private void setFloorText(int floor) {
            String display = "";
            switch (floor) {
                case 1:
                    display = "First Floor";
                    break;
                case 2:
                    display = "Second Floor";
                    break;
                case 3:
                    display = "Third Floor";
                    break;
                case 4:
                    display = "Fourth Floor";
                    break;
                case 5:
                    display = "Fifth Floor";
                    break;
                case 6:
                    display = "Sixth Floor";
                    break;
                case 7:
                    display = "Seventh Floor";
                    break;
                case 8:
                    display = "Eighth Floor";
                    break;
                case 9:
                    display = "Ninth Floor";
                    break;
            }
            mFloorText.setText(display);
        }
    }
}
