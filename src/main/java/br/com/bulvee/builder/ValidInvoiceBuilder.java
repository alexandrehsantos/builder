package br.com.bulvee.builder;

import br.com.bulvee.Invoice;

public class ValidInvoiceBuilder extends InvoiceBuilder {
    private Invoice instance;

    public ValidInvoiceBuilder(Invoice instance) {
        this.instance = instance;
    }

    public Invoice build(){
        return this.instance;
    }

}
