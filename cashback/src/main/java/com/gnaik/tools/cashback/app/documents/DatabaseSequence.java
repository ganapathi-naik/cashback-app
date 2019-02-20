package com.gnaik.tools.cashback.app.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;
    private long sequence;

    public String getId() {
        return id;
    }

    public long getSequence() {
        return sequence;
    }
}
