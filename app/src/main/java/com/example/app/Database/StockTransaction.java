package com.example.app.Database;

public class StockTransaction {
    public static final String TABLE_NAME = "stock_transactions";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type"; // "buy" or "sell"
    public static final String COLUMN_SECURITY_NAME = "security_name";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_PRICE = "price";

    private int id;
    private String type;
    private String securityName;
    private int quantity;
    private double price;

    public StockTransaction(){

    }

    public StockTransaction(int id, String type, String securityName,int quantity, double price){
        this.id=id;
        this.type=type;
        this.securityName=securityName;
        this.quantity=quantity;
        this.price=price;
    }

    //Getter and Setter methods for the class properties


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
