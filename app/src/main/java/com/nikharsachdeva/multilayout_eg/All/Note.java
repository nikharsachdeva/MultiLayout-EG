package com.nikharsachdeva.multilayout_eg.All;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Note {

    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("noteId")
    @Expose
    private Integer noteId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("fileInformations")
    @Expose
    private List<Object> fileInformations = null;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;
    @SerializedName("creatorId")
    @Expose
    private String creatorId;
    @SerializedName("deleted")
    @Expose
    private Boolean deleted;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Object> getFileInformations() {
        return fileInformations;
    }

    public void setFileInformations(List<Object> fileInformations) {
        this.fileInformations = fileInformations;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

}