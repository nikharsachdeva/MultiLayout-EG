package com.nikharsachdeva.multilayout_eg.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.nikharsachdeva.multilayout_eg.All.PastActivity;
import com.nikharsachdeva.multilayout_eg.R;

import java.util.List;

public class OnlyActivityPastAdapter extends RecyclerView.Adapter<OnlyActivityPastAdapter.MyViewHolder> {
    private List<PastActivity> pastActivityList;
    private Context context;


    public OnlyActivityPastAdapter(List<PastActivity> pastActivityList, Context context) {
        this.pastActivityList = pastActivityList;
        this.context = context;
    }


    @NonNull
    @Override
    public OnlyActivityPastAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_past, parent, false);

        return new OnlyActivityPastAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OnlyActivityPastAdapter.MyViewHolder holder, final int position) {

        holder.activity_date_tv_row.setText(pastActivityList.get(position).getActivityDateTime());
        holder.activity_created_by_tv_row.setText(pastActivityList.get(position).getCreatorId());
        holder.activity_meetinghead_tv_row.setText(pastActivityList.get(position).getActivityType() + " :");
        holder.activity_meetingsubhead_tv_row.setText(pastActivityList.get(position).getTitle());
        holder.activity_comment_tv_row.setText("Comments : " + pastActivityList.get(position).getClosingComment());
        holder.activity_desc_tv_row.setText(pastActivityList.get(position).getDescription());

//        for (String tag : pastActivityList.get(position).getTags()) {
//            Chip mChip = (Chip) LayoutInflater.from(context).inflate(R.layout.item_chip_category, null, false);
//            mChip.setText(tag);
//            mChip.setPadding(2, 0, 2, 0);
//            holder.chips_past_activity.addView(mChip);
//
//        }

        if (pastActivityList.get(position).getIsRevertable()) {
            holder.activity_revert_tv_row.setVisibility(View.VISIBLE);
        } else {
            holder.activity_revert_tv_row.setVisibility(View.GONE);
        }

        holder.activity_revert_tv_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new Constant().revertPastActivity(context, pastActivityList.get(position).getLeadActivityId().toString());
            }
        });


    }

    @Override
    public int getItemCount() {
        return pastActivityList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView activity_date_tv_row, activity_created_by_tv_row,
                activity_meetinghead_tv_row, activity_meetingsubhead_tv_row,
                activity_comment_tv_row, activity_revert_tv_row, activity_desc_tv_row;
        ChipGroup chips_past_activity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            activity_date_tv_row = itemView.findViewById(R.id.activity_date_tv_row);
            activity_created_by_tv_row = itemView.findViewById(R.id.activity_created_by_tv_row);
            activity_meetinghead_tv_row = itemView.findViewById(R.id.activity_meetinghead_tv_row);
            activity_meetingsubhead_tv_row = itemView.findViewById(R.id.activity_meetingsubhead_tv_row);
            activity_comment_tv_row = itemView.findViewById(R.id.activity_comment_tv_row);
            activity_revert_tv_row = itemView.findViewById(R.id.activity_revert_tv_row);
            activity_desc_tv_row = itemView.findViewById(R.id.activity_desc_tv_row);
            chips_past_activity = itemView.findViewById(R.id.chips_past_activity);


        }
    }


}
