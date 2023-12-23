package com.homeproject.homeproject.splitwise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Expense {
    private String expenseId;
    private final ISplit split;
    Map<String, Map<String, BigDecimal>> expenseMap = new HashMap<>();
    public Expense(ISplit split) {
        this.expenseId = UUID.randomUUID().toString();
        this.split = split;
    }

    public void addExpense(List<User> users, BigDecimal amount, User payee){
        Map<User,BigDecimal> splitMap = getSplit(users,amount);
        Map<String, BigDecimal> expenseMap = new HashMap<>();
        for(Map.Entry<User,BigDecimal> entry : splitMap.entrySet()){
            if(entry.getKey().getId() == payee.getId()){
                expenseMap.put(entry.getKey().getId(), BigDecimal.valueOf(entry.getValue().doubleValue()));
            }else {
                expenseMap.put(entry.getKey().getId(), BigDecimal.valueOf(entry.getValue().doubleValue()).negate());
            }
        }
        System.out.println(expenseMap);
        this.expenseMap.put(expenseId, expenseMap);
        System.out.println(this.expenseMap);
    }
    public boolean removeExpense(){
        return false;
    }
    public Map<User,BigDecimal> getSplit(List<User> users, BigDecimal amount){
        return split.calculate(users, amount);
    }
    public void printAllExpenses(){
        System.out.println(expenseMap);
    }
}
