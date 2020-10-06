package com.nikharsachdeva.multilayout_eg.MultiAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.ChipGroup;
import com.nikharsachdeva.multilayout_eg.All.PastActivity;
import com.nikharsachdeva.multilayout_eg.All.PendingActivity;
import com.nikharsachdeva.multilayout_eg.All.PinnedNote;
import com.nikharsachdeva.multilayout_eg.All.UnPinnedNote;
import com.nikharsachdeva.multilayout_eg.MultiList.Item;
import com.nikharsachdeva.multilayout_eg.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;

    public Adapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 0 = pinned note 1 = unpinned 2 = pending act 3 = past activity

        if (viewType == 0) {
            return new PinnedViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_notes_pinned, parent, false
                    )
            );
        } else if (viewType == 1) {
            return new UnPinnedViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_notes_unpinned, parent, false
                    )
            );
        } else if (viewType == 2) {
            return new PendingViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_activity_pending, parent, false
                    )
            );
        } else {
            return new PastViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.item_activity_past, parent, false
                    )
            );

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == 0) {
            PinnedNote pinnedNote = (PinnedNote) items.get(position).getObject();
            ((PinnedViewHolder) holder).setPinnedData(pinnedNote);
        } else if (getItemViewType(position) == 1) {
            UnPinnedNote unPinnedNote = (UnPinnedNote) items.get(position).getObject();
            ((UnPinnedViewHolder) holder).setUnpinnedData(unPinnedNote);
        } else if (getItemViewType(position) == 2){
            PendingActivity pendingActivity = (PendingActivity) items.get(position).getObject();
            ((PendingViewHolder) holder).setPendingData(pendingActivity);
        }else {
            PastActivity pastActivity = (PastActivity) items.get(position).getObject();
            ((PastViewHolder) holder).setPastData(pastActivity);

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    static class PinnedViewHolder extends RecyclerView.ViewHolder {

        TextView notes_date_tv_row, notes_desc_tv_row;
        ImageView notes_pen_image_row, notes_close_image_row;
        LinearLayout notes_view_attachment_ll_row;

        PinnedViewHolder(@NonNull final View itemView) {
            super(itemView);

            notes_date_tv_row = itemView.findViewById(R.id.notes_date_tv_row);
            notes_desc_tv_row = itemView.findViewById(R.id.notes_desc_tv_row);
            notes_pen_image_row = itemView.findViewById(R.id.notes_pen_image_row);
            notes_view_attachment_ll_row = itemView.findViewById(R.id.notes_view_attachment_ll_row);
            notes_close_image_row = itemView.findViewById(R.id.notes_close_image_row);
        }

        void setPinnedData(PinnedNote pinnedNote) {

            notes_date_tv_row.setText(pinnedNote.getCreated());
            notes_desc_tv_row.setText(pinnedNote.getContent());

            if (pinnedNote.getFileInformations().size() > 0) {
                notes_view_attachment_ll_row.setVisibility(View.VISIBLE);
            } else {
                notes_view_attachment_ll_row.setVisibility(View.GONE);
            }

        }


    }

    static class UnPinnedViewHolder extends RecyclerView.ViewHolder {

        TextView notes_date_tv_row_up, notes_desc_tv_row_up;
        LinearLayout notes_view_attachment_ll_row_up;

        public UnPinnedViewHolder(@NonNull View itemView) {
            super(itemView);
            notes_date_tv_row_up = itemView.findViewById(R.id.notes_date_tv_row_up);
            notes_desc_tv_row_up = itemView.findViewById(R.id.notes_desc_tv_row_up);
            notes_view_attachment_ll_row_up = itemView.findViewById(R.id.notes_view_attachment_ll_row_up);

        }

        void setUnpinnedData(UnPinnedNote unPinnedNote) {
            notes_date_tv_row_up.setText(unPinnedNote.getCreated());
            notes_desc_tv_row_up.setText(unPinnedNote.getContent());

            if (unPinnedNote.getFileInformations().size() > 0) {
                notes_view_attachment_ll_row_up.setVisibility(View.VISIBLE);
            } else {
                notes_view_attachment_ll_row_up.setVisibility(View.GONE);
            }


        }
    }

    static class PendingViewHolder extends RecyclerView.ViewHolder {

        TextView act_date_tv_row_pen, act_created_by_tv_row_pen,
                act_meet_head_tv_pen, act_meet_subhead_tv_pen,
                act_meet_desc_tv_pen;
        ChipGroup chips_pen_activity;
        EditText act_meet_edit_tv_pen, res_date_act_pen_row, res_time_act_pen_row;
        CheckBox checkbox_act_pen_row;
        Button sub_btn_act_pen_row;
        LinearLayout datetime_con_pend_act;

        public PendingViewHolder(@NonNull View itemView) {
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

        }

        void setPendingData(PendingActivity pendingActivity) {
            act_date_tv_row_pen.setText(pendingActivity.getActivityDateTime());
            act_created_by_tv_row_pen.setText(pendingActivity.getCreatorId());
            act_meet_head_tv_pen.setText(pendingActivity.getActivityType() + " :");
            act_meet_subhead_tv_pen.setText(pendingActivity.getTitle());
            act_meet_desc_tv_pen.setText(pendingActivity.getDescription());

        }
    }

    static class PastViewHolder extends RecyclerView.ViewHolder {

        TextView activity_date_tv_row, activity_created_by_tv_row,
                activity_meetinghead_tv_row, activity_meetingsubhead_tv_row,
                activity_comment_tv_row, activity_revert_tv_row, activity_desc_tv_row;
        ChipGroup chips_past_activity;

        public PastViewHolder(@NonNull View itemView) {
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

        void setPastData(PastActivity pastActivity) {
            activity_date_tv_row.setText(pastActivity.getActivityDateTime());
            activity_created_by_tv_row.setText(pastActivity.getCreatorId());
            activity_meetinghead_tv_row.setText(pastActivity.getActivityType() + " :");
            activity_meetingsubhead_tv_row.setText(pastActivity.getTitle());
            activity_comment_tv_row.setText("Comments : " + pastActivity.getClosingComment());
            activity_desc_tv_row.setText(pastActivity.getDescription());

        }
    }
}
