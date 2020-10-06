package com.nikharsachdeva.multilayout_eg.All;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllNotedAndActivities {

    @SerializedName("pendingActivities")
    @Expose
    private List<PendingActivity_> pendingActivities = null;
    @SerializedName("pinnedNotes")
    @Expose
    private List<PinnedNote_> pinnedNotes = null;
    @SerializedName("pastNotesAndActivities")
    @Expose
    private List<PastNotesAndActivity> pastNotesAndActivities = null;

    public List<PendingActivity_> getPendingActivities() {
        return pendingActivities;
    }

    public void setPendingActivities(List<PendingActivity_> pendingActivities) {
        this.pendingActivities = pendingActivities;
    }

    public List<PinnedNote_> getPinnedNotes() {
        return pinnedNotes;
    }

    public void setPinnedNotes(List<PinnedNote_> pinnedNotes) {
        this.pinnedNotes = pinnedNotes;
    }

    public List<PastNotesAndActivity> getPastNotesAndActivities() {
        return pastNotesAndActivities;
    }

    public void setPastNotesAndActivities(List<PastNotesAndActivity> pastNotesAndActivities) {
        this.pastNotesAndActivities = pastNotesAndActivities;
    }

}