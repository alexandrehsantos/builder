package br.com.bulvee.invoice;

public class InvoiceLegalConsumer extends Invoice{
    @Override
    protected InvoiceTypeConsumer getInvoiceTypeConsumer() {
        return new InvoiceLegalConsumerTax();
    }
}
