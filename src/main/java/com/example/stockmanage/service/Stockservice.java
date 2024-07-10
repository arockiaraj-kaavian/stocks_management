package com.example.stockmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmanage.dao.Stockrepository;
import com.example.stockmanage.model.Products;

import jakarta.transaction.Transactional;


@Service
public class Stockservice {

    // Create a instance for Auto-generate id class file
    @Autowired
    NextSequenceService nextSequenceService;

    // Create a instance for DB repository class
    @Autowired
    Stockrepository stockrepository;

    public boolean saveProduct(Products data){
        // create a new instance for the data created as auto generate id
        Products producttemp = new Products();
        producttemp.setId(nextSequenceService.getNextSequence("DBSequence"));
        producttemp.setProduct(data.getProduct());
        producttemp.setStock(data.getStock());
        producttemp.setPurchasedqty(data.getPurchasedqty());
        producttemp.setSoldqty(data.getSoldqty());
        producttemp.setPrice(data.getPrice());
        producttemp.setOutofstock(false);        
        stockrepository.save(producttemp);

        return true;
}

    public List<Products> getDetails(){
        return stockrepository.findAll();
    }



    @Transactional
    public boolean updatePurchasetoIncreaseStock(Products data) throws Exception {
        Products product = new Products();

        System.out.println("Stock value\t"+ product.getStock());
        System.out.println("Purchasedqty value\t"+ product.getPurchasedqty());

        if (product.getStock() > data.getPurchasedqty()){
            throw new Exception("Already enough stock is available, don't need to purchase");
        }

        product.setPurchasedqty(product.getPurchasedqty() + data.getPurchasedqty());
        product.setStock(product.getStock() + data.getPurchasedqty());
        product.setOutofstock(product.getStock() == 0); 

        stockrepository.save(product);
        return true;
    }

    
    public boolean buyProduct(Products data){

        stockrepository.save(data);
        return true;
    }
}
