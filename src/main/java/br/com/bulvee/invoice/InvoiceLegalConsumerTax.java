package br.com.bulvee.invoice;

import java.math.BigDecimal;

public class InvoiceLegalConsumerTax implements InvoiceTypeConsumer {

    private BigDecimal taxPercent = new BigDecimal("1.04");

    @Override
    public BigDecimal getTax() {
        return taxPercent;
    }
}
