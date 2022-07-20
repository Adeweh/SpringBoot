package com.adeh.diary.service;

import com.adeh.diary.models.Entry;

public interface EntryServices {
    public String addEntry(Entry entry);
    public Entry getEntry(String entryId);
    public void deleteEntry(String entryId);
    void editEntry(String entryId, String newTitle);

}
