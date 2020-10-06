package com.nikharsachdeva.multilayout_eg.All;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingActivity {

    @SerializedName("leadActivityId")
    @Expose
    private Integer leadActivityId;
    @SerializedName("activityDateTime")
    @Expose
    private String activityDateTime;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("lead")
    @Expose
    private Lead lead;
    @SerializedName("isOpen")
    @Expose
    private Boolean isOpen;
    @SerializedName("creatorId")
    @Expose
    private String creatorId;
    @SerializedName("closedBy")
    @Expose
    private Object closedBy;
    @SerializedName("closingComment")
    @Expose
    private Object closingComment;
    @SerializedName("activityType")
    @Expose
    private String activityType;
    @SerializedName("isRevertable")
    @Expose
    private Boolean isRevertable;

    public Integer getLeadActivityId() {
        return leadActivityId;
    }

    public void setLeadActivityId(Integer leadActivityId) {
        this.leadActivityId = leadActivityId;
    }

    public String getActivityDateTime() {
        return activityDateTime;
    }

    public void setActivityDateTime(String activityDateTime) {
        this.activityDateTime = activityDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Object getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Object closedBy) {
        this.closedBy = closedBy;
    }

    public Object getClosingComment() {
        return closingComment;
    }

    public void setClosingComment(Object closingComment) {
        this.closingComment = closingComment;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Boolean getIsRevertable() {
        return isRevertable;
    }

    public void setIsRevertable(Boolean isRevertable) {
        this.isRevertable = isRevertable;
    }

}