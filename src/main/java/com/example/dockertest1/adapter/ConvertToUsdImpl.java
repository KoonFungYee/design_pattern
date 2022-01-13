package com.example.dockertest1.adapter;

import java.math.BigDecimal;

public class ConvertToUsdImpl implements ConvertToUsd {

    private BigDecimal amount;

    public ConvertToUsdImpl(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getTotalAmount() {
        return amount;
    }
}
