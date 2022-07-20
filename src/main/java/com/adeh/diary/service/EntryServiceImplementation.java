package com.adeh.diary.service;

import com.adeh.diary.models.Entry;
import com.adeh.diary.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImplementation implements EntryService {
    @Autowired
    EntryRepository entryRepository;

    @Override
    public String addEntry(Entry entry) {
        entryRepository.save(entry);
        return "entry created successfully";
    }

    @Override
    public Entry getEntry(String entryId) {
        return getEntryFromDB(entryId);

    }
    private Entry getEntryFromDB(String entryId) {
        Optional<Entry> optionalEntry = entryRepository.findById(entryId);
        return optionalEntry.orElseThrow(
            () -> {
                throw new IllegalArgumentException("entry not found");
            });
        }


    @Override
    public void deleteEntry(String entryId) {
        var entry = getEntryFromDB(entryId);
        entryRepository.delete(entry);

    }
    @Override
    public void editEntry(String entryId, String newTitle) {
        var entry= getEntryFromDB(entryId);
        entry.setTitle(newTitle);
        entryRepository.save(entry);

    }

    @Override
    public List<Entry> getAllEntriesFromDB(String phrase) {
        return entryRepository.getAllByContentContainsIgnoreCase(phrase);
    }

    @Override
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }
}