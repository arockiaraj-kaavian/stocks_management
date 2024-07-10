package com.example.stockmanage.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.stockmanage.model.DBSequence;

@Service

public class NextSequenceService {

    @Autowired private MongoOperations mongodb;

    public Integer getNextSequence(String seqName)
    {
        DBSequence counter = mongodb.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            DBSequence.class);
            
        return  !Objects.isNull(counter)?counter.getSeq():1;
    }
}
