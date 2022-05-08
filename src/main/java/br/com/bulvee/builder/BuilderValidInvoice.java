package br.com.bulvee.builder;

import br.com.bulvee.invoice.Invoice;

public class BuilderValidInvoice {
    private Invoice instance;

    public BuilderValidInvoice(Invoice instance) {
        this.instance = instance;
    }

    public Invoice build(){
        return this.instance;
    }
}
