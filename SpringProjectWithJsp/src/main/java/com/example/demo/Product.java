
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.sql.Date;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String description;
    private Date purchasedOn;
    private int qty;
    private double price;

   
    public int getPid() { return pid; }
    public void setPid(int pid) { this.pid = pid; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getPurchasedOn() { return purchasedOn; }
    public void setPurchasedOn(Date purchasedOn) { this.purchasedOn = purchasedOn; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", description=" + description + ", purchasedOn=" + purchasedOn +
               ", qty=" + qty + ", price=" + price + "]";
    }

}