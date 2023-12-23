package com.homeproject.homeproject.vendingmachine;

import java.util.Map;

class OrderCoinsValidator implements Validator<Coin> {

    @Override
    public boolean validate(Map<Coin, Integer> coins) {
        return false;
    }
}
