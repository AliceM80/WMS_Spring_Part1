package com.example.WMS_Spring_Part1.model;

  public class OrderItem {

    private String itemName;
    private int quantity;

    public String getItemName() {
      return itemName;
    }

    public void setItemName(String itemName) {
      this.itemName = itemName;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
  }

