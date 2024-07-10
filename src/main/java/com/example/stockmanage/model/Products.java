package com.example.stockmanage.model;

import jakarta.persistence.Id;
import org.springframework.data.annotation.Transient;
//import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Products {

    @Transient
    public static final String SEQUENCE_NAME = "products_sequence";


    @Id
    private Integer id;
    
    private String product;
    private int stock;
    private int purchasedqty;
    private int soldqty;
    private int price;
    private boolean outofstock;


    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }

    public int getPurchasedqty(){
        return purchasedqty;
    }

    public void setPurchasedqty(int purchasedqty){
        this.purchasedqty = purchasedqty;
    }

    

}


