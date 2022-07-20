package com.adeh.diary.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class Entry {
    @Id
    public String entryId;
    public String title;
    private String content;
}
