package com.nikharsachdeva.multilayout_eg.All;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllResponse {

    @SerializedName("allNotes")
    @Expose
    private AllNotes allNotes;
    @SerializedName("allActivities")
    @Expose
    private AllActivities allActivities;
    @SerializedName("allNotedAndActivities")
    @Expose
    private AllNotedAndActivities allNotedAndActivities;

    public AllNotes getAllNotes() {
        return allNotes;
    }

    public void setAllNotes(AllNotes allNotes) {
        this.allNotes = allNotes;
    }

    public AllActivities getAllActivities() {
        return allActivities;
    }

    public void setAllActivities(AllActivities allActivities) {
        this.allActivities = allActivities;
    }

    public AllNotedAndActivities getAllNotedAndActivities() {
        return allNotedAndActivities;
    }

    public void setAllNotedAndActivities(AllNotedAndActivities allNotedAndActivities) {
        this.allNotedAndActivities = allNotedAndActivities;
    }

}