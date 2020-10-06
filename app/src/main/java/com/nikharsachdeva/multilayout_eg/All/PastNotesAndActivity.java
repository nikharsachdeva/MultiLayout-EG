package com.nikharsachdeva.multilayout_eg.All;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PastNotesAndActivity {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("creator")
    @Expose
    private String creator;
    @SerializedName("leadActivity")
    @Expose
    private LeadActivity leadActivity;
    @SerializedName("note")
    @Expose
    private Note note;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LeadActivity getLeadActivity() {
        return leadActivity;
    }

    public void setLeadActivity(LeadActivity leadActivity) {
        this.leadActivity = leadActivity;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

}