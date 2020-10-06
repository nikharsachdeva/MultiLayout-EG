package com.nikharsachdeva.multilayout_eg.All;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lead {

    @SerializedName("leadId")
    @Expose
    private Integer leadId;

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

}