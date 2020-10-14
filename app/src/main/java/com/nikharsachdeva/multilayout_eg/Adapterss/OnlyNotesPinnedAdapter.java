package com.nikharsachdeva.multilayout_eg.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikharsachdeva.multilayout_eg.All.PinnedNote;
import com.nikharsachdeva.multilayout_eg.R;

import java.util.List;

public class OnlyNotesPinnedAdapter extends RecyclerView.Adapter<OnlyNotesPinnedAdapter.MyViewHolder> {

    //Constant constant = new Constant();
    private List<PinnedNote> pinnedNoteList;
    private Context context;
    private String LeadId;


    public OnlyNotesPinnedAdapter(List<PinnedNote> pinnedNoteList, Context context, String LeadId) {
        this.pinnedNoteList = pinnedNoteList;
        this.context = context;
        this.LeadId = LeadId;
    }

    @NonNull
    @Override
    public OnlyNotesPinnedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes_pinned, parent, false);

        return new OnlyNotesPinnedAdapter.MyViewHolder(view);



    }

    @Override
    public void onBindViewHolder(final OnlyNotesPinnedAdapter.MyViewHolder holder, final int position) {


        holder.notes_date_tv_row.setText(pinnedNoteList.get(position).getCreated());
        holder.notes_desc_tv_row.setText(pinnedNoteList.get(position).getContent());

        if (pinnedNoteList.get(position).getFileInformations().size() > 0) {
            holder.notes_view_attachment_ll_row.setVisibility(View.VISIBLE);
        } else {
            holder.notes_view_attachment_ll_row.setVisibility(View.GONE);
        }

        holder.notes_close_image_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //constant.unPinThisNote(context, pinnedNoteList.get(position).getNoteId());
            }
        });

        holder.notes_view_attachment_ll_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //constant.showFilesNotesDialog(context, pinnedNoteList.get(position).getFileInformations());

            }
        });

        holder.notes_pen_image_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new Constant().showEditNotesDialog(LeadId, pinnedNoteList.get(position).getNoteId(), context, pinnedNoteList.get(position).getFileInformations(), pinnedNoteList.get(position).getContent(), pinnedNoteList.get(position).getPinned());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pinnedNoteList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView notes_date_tv_row, notes_desc_tv_row;
        ImageView notes_pen_image_row, notes_close_image_row;
        LinearLayout notes_view_attachment_ll_row;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            notes_date_tv_row = itemView.findViewById(R.id.notes_date_tv_row);
            notes_desc_tv_row = itemView.findViewById(R.id.notes_desc_tv_row);
            notes_pen_image_row = itemView.findViewById(R.id.notes_pen_image_row);
            notes_view_attachment_ll_row = itemView.findViewById(R.id.notes_view_attachment_ll_row);
            notes_close_image_row = itemView.findViewById(R.id.notes_close_image_row);


        }
    }
}
