package com.nikharsachdeva.multilayout_eg.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.nikharsachdeva.multilayout_eg.All.UnPinnedNote;
import com.nikharsachdeva.multilayout_eg.R;

import java.util.List;

public class OnlyNotesUnPinnedAdapter extends RecyclerView.Adapter<OnlyNotesUnPinnedAdapter.MyViewHolder> {

    private List<UnPinnedNote> unPinnedNoteList;
    private Context context;
    String LEAD_ID_RECEIVED;


    public OnlyNotesUnPinnedAdapter(List<UnPinnedNote> unPinnedNoteList, Context context, String LEAD_ID_RECEIVED) {
        this.unPinnedNoteList = unPinnedNoteList;
        this.context = context;
        this.LEAD_ID_RECEIVED = LEAD_ID_RECEIVED;
    }

    @NonNull
    @Override
    public OnlyNotesUnPinnedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes_unpinned, parent, false);

        return new OnlyNotesUnPinnedAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final OnlyNotesUnPinnedAdapter.MyViewHolder holder, final int position) {

        holder.notes_date_tv_row_up.setText(unPinnedNoteList.get(position).getCreated());
        holder.notes_desc_tv_row_up.setText(unPinnedNoteList.get(position).getContent());

        if (unPinnedNoteList.get(position).getFileInformations().size() > 0) {
            holder.notes_view_attachment_ll_row_up.setVisibility(View.VISIBLE);
        } else {
            holder.notes_view_attachment_ll_row_up.setVisibility(View.GONE);
        }

        holder.notes_view_attachment_ll_row_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //constant.showFilesUnPinNotesDialog(context, unPinnedNoteList.get(position).getFileInformations());

            }
        });
    }

    @Override
    public int getItemCount() {
        return unPinnedNoteList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView notes_date_tv_row_up, notes_desc_tv_row_up;
        LinearLayout notes_view_attachment_ll_row_up;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            notes_date_tv_row_up = itemView.findViewById(R.id.notes_date_tv_row_up);
            notes_desc_tv_row_up = itemView.findViewById(R.id.notes_desc_tv_row_up);
            notes_view_attachment_ll_row_up = itemView.findViewById(R.id.notes_view_attachment_ll_row_up);


        }
    }
}
