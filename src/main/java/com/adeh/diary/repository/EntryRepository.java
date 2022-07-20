package com.adeh.diary.repository;

import com.adeh.diary.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EntryRepository extends MongoRepository<Entry, String> {

   List<Entry> getAllByContentContainsIgnoreCase(String phrase);
}
