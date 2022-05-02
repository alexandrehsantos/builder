package br.com.bulvee.builder;

import br.com.bulvee.Invoice;
import br.com.bulvee.Product;
import br.com.bulvee.calculation.TaxCalculator;
import br.com.bulvee.calculation.TaxCalculatorForLegal;
import br.com.bulvee.calculation.TaxCalculatorForNaturalPerson;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InvoiceBuilder {

    private Invoice instance;

    public InvoiceBuilder(){
        this.instance = new Invoice();
    }

    public InvoiceBuilder withItem(String name, double quantity, String unityValue){
        Product item = new Product();
        item.setName(name);
        item.setQuantity(quantity);
        item.setValue(new BigDecimal(unityValue));

        if(this.instance.getItems() == null){
            this.instance.setItems(new ArrayList<Product>());
        }
        this.instance.getItems().add(item);
        return this;
    }

    public InvoiceBuilder withNumber(String number){
        this.instance.setNumber(number);
        return new ValidInvoiceBuilder(this.instance);
    }

    //TODO
    public InvoiceBuilder forNaturalPerson(){
        TaxCalculator taxCalculator = new TaxCalculatorForNaturalPerson();
        return this;
    }

    //TODO
    public InvoiceBuilder forLegal(){
        TaxCalculator taxCalculator = new TaxCalculatorForLegal();
        return this;
    }

}
