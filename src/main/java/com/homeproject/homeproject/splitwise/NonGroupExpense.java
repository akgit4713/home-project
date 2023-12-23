package com.homeproject.homeproject.splitwise;

import java.math.BigDecimal;
import java.util.List;

public class NonGroupExpense extends Expense{
    public NonGroupExpense(ISplit split) {
        super(split);
    }

    @Override
    public void addExpense(List<User> users, BigDecimal amount, User payee) {

    }

    @Override
    public boolean removeExpense() {
        return false;
    }
}
