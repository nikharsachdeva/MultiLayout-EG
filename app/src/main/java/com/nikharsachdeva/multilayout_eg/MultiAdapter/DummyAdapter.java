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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.ChipGroup;
import com.nikharsachdeva.multilayout_eg.Adapterss.OnlyActivityPastAdapter;
import com.nikharsachdeva.multilayout_eg.Adapterss.OnlyActivityPendAdapter;
import com.nikharsachdeva.multilayout_eg.Adapterss.OnlyNotesPinnedAdapter;
import com.nikharsachdeva.multilayout_eg.Adapterss.OnlyNotesUnPinnedAdapter;
import com.nikharsachdeva.multilayout_eg.All.PastActivity;
import com.nikharsachdeva.multilayout_eg.All.PendingActivity;
import com.nikharsachdeva.multilayout_eg.All.PinnedNote;
import com.nikharsachdeva.multilayout_eg.All.UnPinnedNote;
import com.nikharsachdeva.multilayout_eg.MultiList.DummyItem;
import com.nikharsachdeva.multilayout_eg.MultiList.Item;
import com.nikharsachdeva.multilayout_eg.R;

import java.util.List;

public class DummyAdapter extends RecyclerView.Adapter {

    private List<DummyItem> dummyItemList;

    public DummyAdapter(List<DummyItem> dummyItemList) {
        this.dummyItemList = dummyItemList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (dummyItemList.get(position).getType()) {
            case 0:
                return DummyItem.PINNED_NOTES;
            case 1:
                return DummyItem.UNPINNED_NOTES;
            case 2:
                return DummyItem.PENDING_ACTIVITIES;
            case 3:
                return DummyItem.PAST_ACTIVITIES;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case DummyItem.PINNED_NOTES:
                View pinnedview = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_layout_pinned_note, parent, false);
                return new pinnedNotesViewHolder(pinnedview);
            case DummyItem.UNPINNED_NOTES:
                View unpinnedview = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_layout_unpinned_note, parent, false);
                return new unpinnedNotesViewHolder(unpinnedview);
            case DummyItem.PENDING_ACTIVITIES:
                View pendingview = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_layout_pending_activity, parent, false);
                return new pendingActivitiesViewHolder(pendingview);
            case DummyItem.PAST_ACTIVITIES:
                View pastview = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_layout_past_activity, parent, false);
                return new pastActivitiesViewHolder(pastview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (dummyItemList.get(position).getType()) {
            case DummyItem.PINNED_NOTES:
                List<PinnedNote> pinnedNoteList = dummyItemList.get(position).getAllResponseObj().getAllNotes().getPinnedNotes();
                ((pinnedNotesViewHolder) holder).setPinnedNotesData(pinnedNoteList);
                break;
            case DummyItem.UNPINNED_NOTES:
                List<UnPinnedNote> unPinnedNoteList = dummyItemList.get(position).getAllResponseObj().getAllNotes().getUnPinnedNotes();
                ((unpinnedNotesViewHolder) holder).setUnPinnedNotesData(unPinnedNoteList);
                break;
            case DummyItem.PENDING_ACTIVITIES:
                List<PendingActivity> pendingActivityList = dummyItemList.get(position).getAllResponseObj().getAllActivities().getPendingActivities();
                ((pendingActivitiesViewHolder) holder).setPendingData(pendingActivityList);
                break;
            case DummyItem.PAST_ACTIVITIES:
                List<PastActivity> pastActivityList = dummyItemList.get(position).getAllResponseObj().getAllActivities().getPastActivities();
                ((pastActivitiesViewHolder) holder).setPastData(pastActivityList);
                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return dummyItemList.size();
    }

    public class pinnedNotesViewHolder extends RecyclerView.ViewHolder {

        TextView pinned_notes_notes_tv;
        RecyclerView pinned_notes_notes_rv;

        public pinnedNotesViewHolder(@NonNull View itemView) {
            super(itemView);
            pinned_notes_notes_tv = itemView.findViewById(R.id.pinned_notes_notes_tv);
            pinned_notes_notes_rv = itemView.findViewById(R.id.pinned_notes_notes_rv);

        }

        public void setPinnedNotesData(List<PinnedNote> pinnedNoteList) {
            pinned_notes_notes_tv.setText("Pinned Notes (" + pinnedNoteList.size() + ")");
            OnlyNotesPinnedAdapter adapter = new OnlyNotesPinnedAdapter(pinnedNoteList, itemView.getContext(), "55214");
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            pinned_notes_notes_rv.setLayoutManager(layoutManager);
            pinned_notes_notes_rv.setAdapter(adapter);

        }
    }

    public class unpinnedNotesViewHolder extends RecyclerView.ViewHolder {

        TextView unpinned_notes_notes_tv;
        RecyclerView unpinned_notes_notes_rv;

        public unpinnedNotesViewHolder(@NonNull View itemView) {
            super(itemView);
            unpinned_notes_notes_tv = itemView.findViewById(R.id.unpinned_notes_notes_tv);
            unpinned_notes_notes_rv = itemView.findViewById(R.id.unpinned_notes_notes_rv);

        }

        public void setUnPinnedNotesData(List<UnPinnedNote> unPinnedNoteList) {
            unpinned_notes_notes_tv.setText("Unpinned Notes (" + unPinnedNoteList.size() + ")");
            OnlyNotesUnPinnedAdapter adapter = new OnlyNotesUnPinnedAdapter(unPinnedNoteList, itemView.getContext(), "55214");
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            unpinned_notes_notes_rv.setLayoutManager(layoutManager);
            unpinned_notes_notes_rv.setAdapter(adapter);

        }
    }

    public class pendingActivitiesViewHolder extends RecyclerView.ViewHolder {

        TextView pending_activity_activity_tv;
        RecyclerView pending_activity_activity_rv;

        public pendingActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            pending_activity_activity_tv = itemView.findViewById(R.id.pending_activity_activity_tv);
            pending_activity_activity_rv = itemView.findViewById(R.id.pending_activity_activity_rv);

        }

        public void setPendingData(List<PendingActivity> pendingActivityList) {
            pending_activity_activity_tv.setText("Pending Activities (" + pendingActivityList.size() + ")");
            OnlyActivityPendAdapter adapter = new OnlyActivityPendAdapter(pendingActivityList, itemView.getContext(), "55214");
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            pending_activity_activity_rv.setLayoutManager(layoutManager);
            pending_activity_activity_rv.setAdapter(adapter);

        }
    }

    public class pastActivitiesViewHolder extends RecyclerView.ViewHolder {

        TextView past_activity_activity_tv;
        RecyclerView past_activity_activity_rv;

        public pastActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            past_activity_activity_tv = itemView.findViewById(R.id.past_activity_activity_tv);
            past_activity_activity_rv = itemView.findViewById(R.id.past_activity_activity_rv);

        }

        public void setPastData(List<PastActivity> pastActivityList) {
            past_activity_activity_tv.setText("Past Activities (" + pastActivityList.size() + ")");
            OnlyActivityPastAdapter adapter = new OnlyActivityPastAdapter(pastActivityList, itemView.getContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false);
            past_activity_activity_rv.setLayoutManager(layoutManager);
            past_activity_activity_rv.setAdapter(adapter);

        }
    }


}
