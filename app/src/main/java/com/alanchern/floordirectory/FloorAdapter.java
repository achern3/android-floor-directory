package com.alanchern.floordirectory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alanchern on 1/12/17.
 */

public class FloorAdapter extends RecyclerView.Adapter<FloorAdapter.FloorViewHolder> {
    private int mNumberFloors;

    public FloorAdapter(int numberFloors) {
        mNumberFloors = numberFloors;
    }

    @Override
    public FloorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.floor_view_holder, null);
        return new FloorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FloorViewHolder holder, int position) {
        holder.bind(position + 1);
    }

    @Override
    public int getItemCount() {
        return mNumberFloors;
    }

    class FloorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Context mContext;
        private TextView mFloorText;
        private ImageView mFloorImage;
        private int mFloor;

        FloorViewHolder(View itemView) {
            super(itemView);

            mContext = itemView.getContext();

            mFloorText = (TextView) itemView.findViewById(R.id.floor_text);
            mFloorImage = (ImageView) itemView.findViewById(R.id.floor_image);

            itemView.setOnClickListener(this);
            mFloorText.setOnClickListener(this);
        }

        void bind(int floor) {
            mFloor = floor;
            if (mFloorText != null) {
                mFloorText.setText(mContext.getString(R.string.floor, floor));
            }
        }

        @Override
        public void onClick(View view) {
            ((MainActivity) mContext).showFloorUnit(mFloor);
        }
    }
}
