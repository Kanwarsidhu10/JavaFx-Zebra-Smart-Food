/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.time.LocalDate;

/**
 *
 * @author snehk_000
 */
public class Order {
    int id,p_id,c_id,quantity,amount,total;
    LocalDate date_of_order,date_of_delievery;
    String p_name,p_code,p_category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDate getDate_of_order() {
        return date_of_order;
    }

    public void setDate_of_order(LocalDate date_of_order) {
        this.date_of_order = date_of_order;
    }

    public LocalDate getDate_of_delievery() {
        return date_of_delievery;
    }

    public void setDate_of_delievery(LocalDate date_of_delievery) {
        this.date_of_delievery = date_of_delievery;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }
    
    
}
