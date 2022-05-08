package br.com.bulvee.invoice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class Invoice {

    private String number;
    private Date date;
    private List<ItemProduct> items;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemProduct> getItems() {
        return items;
    }

    public void setItems(List<ItemProduct> items) {
        this.items = items;
    }

    public BigDecimal getTotalValue() {
        return this.items.stream().map(ItemProduct::getValue).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public BigDecimal getTotalValueWithTax() {
        BigDecimal totalValue = this.getTotalValue();

        if (totalValue.equals(BigDecimal.ZERO)) {
            return new BigDecimal("0.0");
        }
        return totalValue.multiply(getInvoiceTypeConsumer().getTax());
    }

    protected abstract InvoiceTypeConsumer getInvoiceTypeConsumer();
}
