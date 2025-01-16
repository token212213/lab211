
package model;

import java.util.Date;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Product {

    private String id;
    private String name;
    private String location;
    private double price;
    private Date expDate;
    private Date manuDate;
    private Storekeeper storekeeper;
    private Date receiptDate;
    private String category;

    public Product() {
    }

    public Product(String id, String name, String location, double price, Date expDate, Date manuDate, Storekeeper storekeeper, Date receiptDate, String category) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expDate = expDate;
        this.manuDate = manuDate;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getManuDate() {
        return manuDate;
    }

    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
//    String id, String name, String location, double price, Date expDate, Date manuDate, Storekeeper storekeeper, Date receiptDate, String category
    public void print(){
        System.out.printf("%-5s%-15s%-10s%-8.1f  %td/%tm/%ty %td/%tm/%ty %td/%tm/%ty %-15s %-5s\n",this.id, this.name, this.location, this.price, this.expDate, this.manuDate, this.receiptDate, this.storekeeper.getStorekeeperName(),this.category);
    }
    
    

}
