//Author : Manish Kote S
package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemID;
    private String itemName;
    private double itemPrice;

    // Constructors (if needed)

    // Getter for itemID
    public Long getItemID() {
        return itemID;
    }

    // Setter for itemID
    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    // Getter for itemName
    public String getItemName() {
        return itemName;
    }

    // Setter for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for itemPrice
    public double getItemPrice() {
        return itemPrice;
    }

    // Setter for itemPrice
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
