package com.adeh.diary.service;

import com.adeh.diary.models.Entry;

import java.util.List;

public interface EntryService {
    String addEntry(Entry entry);
    Entry getEntry(String entryId);
    void deleteEntry(String entryId);

    void editEntry(String entryId, String newTitle);

    //List<Entry> getAllEntriesFromDB(String entryId);

    List<Entry> getAllEntriesFromDB(String phrase);
    List<Entry> getAllEntries();
}
