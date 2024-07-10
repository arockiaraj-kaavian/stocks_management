package com.example.stockmanage.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@Document(collection = "db_Sequences")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DBSequence {

    @Id
    private String id;

    private int seq;


}
