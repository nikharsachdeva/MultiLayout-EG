package com.nikharsachdeva.multilayout_eg.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.nikharsachdeva.multilayout_eg.All.PendingActivity;
import com.nikharsachdeva.multilayout_eg.R;

import java.util.List;

public class OnlyActivityPendAdapter extends RecyclerView.Adapter<OnlyActivityPendAdapter.MyViewHolder> {
    public static final String TAG = "PendingAdapter";
    private List<PendingActivity> pendingActivityList;
    private Context context;
    public String loginToken;


    public OnlyActivityPendAdapter(List<PendingActivity> pendingActivityList, Context context, String loginToken) {
        this.pendingActivityList = pendingActivityList;
        this.context = context;
        this.loginToken = loginToken;

    }


    @NonNull
    @Override
    public OnlyActivityPendAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_pending, parent, false);

        return new OnlyActivityPendAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OnlyActivityPendAdapter.MyViewHolder holder, final int position) {

        holder.act_date_tv_row_pen.setText(pendingActivityList.get(position).getActivityDateTime());
        holder.act_created_by_tv_row_pen.setText(pendingActivityList.get(position).getCreatorId());
        holder.act_meet_head_tv_pen.setText(pendingActivityList.get(position).getActivityType() + " :");
        holder.act_meet_subhead_tv_pen.setText(pendingActivityList.get(position).getTitle());
        holder.act_meet_desc_tv_pen.setText(pendingActivityList.get(position).getDescription());

        holder.checkbox_act_pen_row.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.datetime_con_pend_act.setVisibility(View.VISIBLE);
                } else {
                    holder.datetime_con_pend_act.setVisibility(View.GONE);

                }
            }
        });

        holder.res_date_act_pen_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //constant.showDateDialog(context, holder.res_date_act_pen_row);
            }
        });

        holder.res_time_act_pen_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //constant.showTimeDialog(context, holder.res_time_act_pen_row);
            }
        });

//        for (String tag : pendingActivityList.get(position).getTags()) {
//            Chip mChip = (Chip) LayoutInflater.from(context).inflate(R.layout.item_chip_category, null, false);
//            mChip.setText(tag);
//            mChip.setPadding(2, 0, 2, 0);
//            holder.chips_pen_activity.addView(mChip);
//
//        }

//        holder.sub_btn_act_pen_row.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (validateBeforeSubmit(holder)) {
//                    //crmLeadActivity crmLeadActivityObj = new crmLeadActivity();
//                    new Constant().submitActivity(
//                            loginToken,
//                            pendingActivityList.get(position).getLeadActivityId()
//                            , context, holder.checkbox_act_pen_row.isChecked(),
//                            holder.act_meet_edit_tv_pen.getText().toString(),
//                            holder.res_date_act_pen_row.getText().toString() + " " + holder.res_time_act_pen_row.getText().toString());
//                }
//            }
//        });

        if (pendingActivityList.get(position).getIsRevertable()) {
            holder.pend_activity_revert_tv_row.setVisibility(View.VISIBLE);
        } else {
            holder.pend_activity_revert_tv_row.setVisibility(View.GONE);
        }

        holder.pend_activity_revert_tv_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new Constant().revertPastActivity(context, pendingActivityList.get(position).getLeadActivityId().toString());
            }
        });



    }

    private boolean validateBeforeSubmit(OnlyActivityPendAdapter.MyViewHolder holder) {
        boolean allow = true;
        if (holder.checkbox_act_pen_row.isChecked()) {
            if (holder.res_date_act_pen_row.getText().length() == 0) {
                allow = false;
                holder.res_date_act_pen_row.setError("Required");
            }
            if (holder.res_time_act_pen_row.getText().length() == 0) {
                allow = false;
                holder.res_time_act_pen_row.setError("Required");
            }

        }
        if (holder.act_meet_edit_tv_pen.getText().length() == 0) {
            allow = false;
            holder.act_meet_edit_tv_pen.setError("Required");
        }


        return allow;

    }

    @Override
    public int getItemCount() {
        return pendingActivityList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView act_date_tv_row_pen, act_created_by_tv_row_pen,
                act_meet_head_tv_pen, act_meet_subhead_tv_pen,
                act_meet_desc_tv_pen,pend_activity_revert_tv_row;
        ChipGroup chips_pen_activity;
        EditText act_meet_edit_tv_pen, res_date_act_pen_row, res_time_act_pen_row;
        CheckBox checkbox_act_pen_row;
        Button sub_btn_act_pen_row;
        LinearLayout datetime_con_pend_act;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            act_date_tv_row_pen = itemView.findViewById(R.id.act_date_tv_row_pen);
            act_created_by_tv_row_pen = itemView.findViewById(R.id.act_created_by_tv_row_pen);
            act_meet_head_tv_pen = itemView.findViewById(R.id.act_meet_head_tv_pen);
            act_meet_subhead_tv_pen = itemView.findViewById(R.id.act_meet_subhead_tv_pen);
            act_meet_desc_tv_pen = itemView.findViewById(R.id.act_meet_desc_tv_pen);
            chips_pen_activity = itemView.findViewById(R.id.chips_pen_activity);
            act_meet_edit_tv_pen = itemView.findViewById(R.id.act_meet_edit_tv_pen);
            res_date_act_pen_row = itemView.findViewById(R.id.res_date_act_pen_row);
            res_time_act_pen_row = itemView.findViewById(R.id.res_time_act_pen_row);
            checkbox_act_pen_row = itemView.findViewById(R.id.checkbox_act_pen_row);
            sub_btn_act_pen_row = itemView.findViewById(R.id.sub_btn_act_pen_row);
            datetime_con_pend_act = itemView.findViewById(R.id.datetime_con_pend_act);
            pend_activity_revert_tv_row = itemView.findViewById(R.id.pend_activity_revert_tv_row);
        }
    }


}
