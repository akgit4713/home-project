package com.homeproject.homeproject.splitwise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements ISplit{
    @Override
    public Map<User, BigDecimal> calculate(List<User> users, BigDecimal amount) {
        Map<User,BigDecimal> splitMap = new HashMap<>();
        BigDecimal equalSplitAmount = amount.divide(new BigDecimal(users.size()));
        for (User user : users){
            splitMap.put(user,equalSplitAmount);
        }
        return splitMap;
    }
}
