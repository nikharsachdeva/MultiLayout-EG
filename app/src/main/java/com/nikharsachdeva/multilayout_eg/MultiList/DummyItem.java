package com.nikharsachdeva.multilayout_eg.MultiList;

import com.nikharsachdeva.multilayout_eg.All.AllResponse;
import com.nikharsachdeva.multilayout_eg.All.PinnedNote;
import com.nikharsachdeva.multilayout_eg.All.UnPinnedNote;

import java.util.List;

public class DummyItem {

    public static final int PINNED_NOTES = 0;
    public static final int UNPINNED_NOTES = 1;
    public static final int PENDING_ACTIVITIES = 2;
    public static final int PAST_ACTIVITIES = 3;

    private int type;

//    private List<PinnedNote> pinnedNoteList;
//    private List<UnPinnedNote> unPinnedNoteList;
    private AllResponse allResponseObj;

    public DummyItem(int type, AllResponse allResponseObj) {
        this.type = type;
        this.allResponseObj = allResponseObj;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public AllResponse getAllResponseObj() {
        return allResponseObj;
    }

    public void setAllResponseObj(AllResponse allResponseObj) {
        this.allResponseObj = allResponseObj;
    }
}
