package com.homeproject.homeproject.vendingmachine;

import java.util.Map;

class CoinInventory implements Inventory<Coin> {
    Map<Coin, Integer> coins;
    Validator<Coin> orderValidator;

    public CoinInventory(Map<Coin, Integer> coins) {
        this.coins = coins;
        this.orderValidator = new OrderCoinsValidator();
    }

    @Override
    public Map<Coin, Integer> getAll() {
        return this.coins;
    }

    @Override
    public void updateInventory(Coin coin, Integer countToAdd) {

    }

    @Override
    public boolean validate(Map<Coin, Integer> map) {
        return orderValidator.validate(map);
    }
}
