package br.com.bulvee.builder;

import br.com.bulvee.invoice.InvoiceLegalConsumer;
import br.com.bulvee.invoice.InvoiceNaturalConsumer;

public class BuilderInvoice {

    public BuilderInvoiceTypeConsumer withNaturalConsumer() {
        return new BuilderInvoiceTypeConsumer(new InvoiceLegalConsumer());
    }

    public BuilderInvoiceTypeConsumer withLegalConsumer() {
        return new BuilderInvoiceTypeConsumer(new InvoiceNaturalConsumer());
    }
}
