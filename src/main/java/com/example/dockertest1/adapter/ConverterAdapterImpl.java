package com.example.dockertest1.adapter;

import java.math.BigDecimal;

public class ConverterAdapterImpl implements ConverterAdapter {
    private ConvertToUsd currency;
    
    public ConverterAdapterImpl(ConvertToUsd currency) {
        this.currency = currency;
    }

    @Override
    public BigDecimal convert() {
        return convertToUSD(currency.getTotalAmount());
    }

    private BigDecimal convertToUSD(BigDecimal amount) {
        return amount.divide(BigDecimal.valueOf(4.2), BigDecimal.ROUND_UP).setScale(2);
    }
}
