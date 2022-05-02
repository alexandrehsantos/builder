package br.com.bulvee;

import java.util.Date;
import java.util.List;

public class Invoice {

    private String number;
    private Date date;
    private List<Product> items;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
