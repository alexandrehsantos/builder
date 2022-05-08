package br.com.bulvee.builder;

import br.com.bulvee.invoice.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Random;

class BuilderInvoiceTest {

    BuilderInvoice builderInvoice;
    private String invoiceNumber;

    @BeforeEach
    void setUp() {
        this.builderInvoice = new BuilderInvoice();
        invoiceNumber = String.valueOf(generateInvoiceNumber());
    }

    @Test
    void givenInvoice_whenLegalConsumer_checkTaxValue_thenVerify(TestInfo testInfo) throws ParseException {
        System.out.println("displayName = " + testInfo.getDisplayName());

        BigDecimal taxForLegal = new BigDecimal("1.07");

        Invoice invoice = builderInvoice.withLegalConsumer()
                .withIssueDate("07/05/2022")
                .withProduct("pen", 1000, 500)
                .withProduct("coffee", 100, 1000)
                .withNumber(invoiceNumber).build();

        BigDecimal totalValue = invoice.getTotalValue();
        BigDecimal totalValueWithTax = invoice.getTotalValueWithTax();

        BigDecimal tax = compareTax(totalValue, totalValueWithTax);

        Assertions.assertEquals(taxForLegal, tax);
    }

    @Test
    void givenInvoice_whenNaturalConsumer_checkTaxValue_thanVerify(TestInfo testInfo) throws ParseException {
        System.out.println("displayName = " + testInfo.getDisplayName());

        BigDecimal taxForNatural = new BigDecimal("1.04");

        Invoice invoice = builderInvoice.withNaturalConsumer()
                .withIssueDate("07/05/2022")
                .withProduct("toilet paper", 1, "23.4")
                .withProduct("potatoes", 250, 2.5)
                .withNumber(invoiceNumber)
                .build();

        BigDecimal totalValue = invoice.getTotalValue();
        BigDecimal totalValueWithTax = invoice.getTotalValueWithTax();

        BigDecimal tax = compareTax(totalValue, totalValueWithTax);

        Assertions.assertEquals(taxForNatural, tax);
    }

    private BigDecimal compareTax(BigDecimal totalValue, BigDecimal totalValueWithTax) {
        return totalValueWithTax.divide(totalValue);
    }

    private int generateInvoiceNumber() {
        Random random = new Random();
        int invoiceNumber = random.nextInt();
        return invoiceNumber;
    }
}