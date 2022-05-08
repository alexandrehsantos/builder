package br.com.bulvee.builder;

import br.com.bulvee.invoice.Invoice;
import br.com.bulvee.invoice.ItemProduct;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BuilderInvoiceTypeConsumer {

    private Invoice instance;

    public BuilderInvoiceTypeConsumer(Invoice invoice){
        this.instance = invoice;
    }

    public BuilderInvoiceTypeConsumer withIssueDate(String issueDate) throws ParseException {
        try {
            this.instance.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(issueDate));
        } catch (ParseException e) {
            System.out.println("Type a valid issue date in this pattern dd/MM/yyyy");
            throw e;
        }
        return this;
    }

    public BuilderInvoiceTypeConsumer withProduct(String name, double quantity, String unityValue){
        buildItemProduct(name, quantity, new BigDecimal(unityValue));
        return this;
    }

    public BuilderInvoiceTypeConsumer withProduct(String name, double quantity, double unityValue){
        buildItemProduct(name, quantity, new BigDecimal(unityValue));
        return this;
    }

    public BuilderValidInvoice withNumber(String number){
        this.instance.setNumber(number);
        return new BuilderValidInvoice(this.instance);
    }

    private void buildItemProduct(String name, double quantity, BigDecimal unityValue) {
        ItemProduct item = new ItemProduct();
        item.setName(name);
        item.setQuantity(quantity);
        item.setValue(unityValue);

        if(this.instance.getItems() == null){
            this.instance.setItems(new ArrayList<ItemProduct>());
        }
        this.instance.getItems().add(item);
    }
}
