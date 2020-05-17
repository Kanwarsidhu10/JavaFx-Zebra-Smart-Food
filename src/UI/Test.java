/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BO.Product;
import DA.ProductDA;

/**
 *
 * @author snehk_000
 */
public class Test {
    public static void main(String[] args) {
        Product product=new Product();
        product.setAmount(54);
        product.setCategory("gag");
        product.setCode("pa");
        product.setDescription("das");
        product.setId(0);
        product.setName("adas");
        ProductDA.add(product);
    }
    
}
