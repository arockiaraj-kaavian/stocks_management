package com.example.stockmanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmanage.model.Products;
import com.example.stockmanage.service.Stockservice;

@RestController
@RequestMapping("/api")
public class Stockcontroller {

    @Autowired 
    Stockservice stockmaintain;



@PostMapping("/addProduct")
public String saveProduct (@RequestBody Products data){
    System.out.println(data);

    boolean isAdd = stockmaintain.saveProduct(data);
    if(isAdd){
        return "Product saved successfully";
    }else{
        return "Product addition failed";
    }

}

@GetMapping("/getData")
public List<Products> getDetails(){

    return stockmaintain.getDetails();
    
}

@PutMapping("/editProduct/sample")
public String buyProduct(@RequestBody Products data){
     
    boolean isEdit = stockmaintain.buyProduct(data);
    if(isEdit){
        return "The Product edited successfully";
    }else{
        return "The Product edition failed";
    }
} 

@PutMapping("/editProduct/purchase")
public String updatePurchasetoIncreaseStock(@RequestBody Products data) throws Exception {
    
    boolean isbuy = stockmaintain.updatePurchasetoIncreaseStock(data);

        if(isbuy)
        {
            return "Product Purchased successfully";
        }else
        {
            return "Product Purchase updation failed";
        }
    }

}
