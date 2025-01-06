package com.example.metro_tailor;

public class Model {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;
    //    public String id;
    String Company;

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    String Product;
    String Number;
    String Quantity;
    String Rate;
    String Total;

    public Model(String company, String product, String number, String quantity, String rate, String total) {
        Company = company;
        Product = product;
        Number = number;
        Quantity = quantity;
        Rate = rate;
        Total = total;
    }
    public Model(String id,String company, String product, String number, String quantity, String rate, String total) {
        this.id = id;
        Company = company;
        Product = product;
        Number = number;
        Quantity = quantity;
        Rate = rate;
        Total = total;
    }
}
