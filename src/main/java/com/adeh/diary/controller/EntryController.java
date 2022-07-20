package com.adeh.diary.controller;

import com.adeh.diary.models.Entry;
import com.adeh.diary.service.EntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entry")
@Slf4j
public class EntryController {
@Autowired
    EntryService entryService;

    @PostMapping("/addEntry")
    public String addEntry(@RequestBody Entry entry) {
        return entryService.addEntry(entry);
    }

    @GetMapping("/getEntry/{entryId}")
    public Entry getEntry(@PathVariable("entryId") String entryId) {
        return entryService.getEntry(entryId);
    }

    @PatchMapping("/editEntry/{entryId}/{newTitle}")
    public ResponseEntity<?> editEntry(@PathVariable String entryId, @PathVariable String newTitle) {
        try {
            entryService.editEntry(entryId, newTitle);
            return new ResponseEntity<>("edited success", HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteEntry")
    public ResponseEntity<?> deleteEntry(@RequestParam String entryId) {
        try {
            entryService.deleteEntry(entryId);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getAllEntries")
    public List<Entry> getAllEntries(@RequestParam String phrase) {
        return entryService.getAllEntriesFromDB(phrase);
    }
}
