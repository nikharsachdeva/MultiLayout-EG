package com.nikharsachdeva.multilayout_eg.All;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllActivities {

    @SerializedName("pendingActivities")
    @Expose
    private List<PendingActivity> pendingActivities = null;
    @SerializedName("pastActivities")
    @Expose
    private List<PastActivity> pastActivities = null;

    public List<PendingActivity> getPendingActivities() {
        return pendingActivities;
    }

    public void setPendingActivities(List<PendingActivity> pendingActivities) {
        this.pendingActivities = pendingActivities;
    }

    public List<PastActivity> getPastActivities() {
        return pastActivities;
    }

    public void setPastActivities(List<PastActivity> pastActivities) {
        this.pastActivities = pastActivities;
    }

}