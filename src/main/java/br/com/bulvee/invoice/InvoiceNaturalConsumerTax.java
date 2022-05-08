package br.com.bulvee.invoice;

import java.math.BigDecimal;

public class InvoiceNaturalConsumerTax implements InvoiceTypeConsumer {

    private BigDecimal tax = new BigDecimal("1.07");

    @Override
    public BigDecimal getTax() {
        return tax;
    }
}
