package com.homeproject.homeproject.vendingmachine;

import java.util.Map;

interface Validator<K> {
    public boolean validate(Map<K, Integer> provided);
}
