package com.nikharsachdeva.multilayout_eg.All;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileInformation {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fileUUId")
    @Expose
    private String fileUUId;
    @SerializedName("fileName")
    @Expose
    private String fileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileUUId() {
        return fileUUId;
    }

    public void setFileUUId(String fileUUId) {
        this.fileUUId = fileUUId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}