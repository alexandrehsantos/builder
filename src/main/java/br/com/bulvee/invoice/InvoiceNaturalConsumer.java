package br.com.bulvee.invoice;

public class InvoiceNaturalConsumer extends Invoice{
    @Override
    protected InvoiceTypeConsumer getInvoiceTypeConsumer() {
        return new InvoiceNaturalConsumerTax();
    }
}
