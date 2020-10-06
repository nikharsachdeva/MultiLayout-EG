package com.nikharsachdeva.multilayout_eg.All;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllNotes {

    @SerializedName("pinnedNotes")
    @Expose
    private List<PinnedNote> pinnedNotes = null;
    @SerializedName("unPinnedNotes")
    @Expose
    private List<UnPinnedNote> unPinnedNotes = null;

    public List<PinnedNote> getPinnedNotes() {
        return pinnedNotes;
    }

    public void setPinnedNotes(List<PinnedNote> pinnedNotes) {
        this.pinnedNotes = pinnedNotes;
    }

    public List<UnPinnedNote> getUnPinnedNotes() {
        return unPinnedNotes;
    }

    public void setUnPinnedNotes(List<UnPinnedNote> unPinnedNotes) {
        this.unPinnedNotes = unPinnedNotes;
    }

}
