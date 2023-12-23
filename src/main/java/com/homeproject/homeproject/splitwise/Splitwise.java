package com.homeproject.homeproject.splitwise;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Splitwise {

    public static void main(String[] args) {
        User user1 = new User("Anurag");
        User user2 = new User("Utkarsh");
        User user3 = new User("Aman");
        User user4 = new User("Harsh");

        Expense expense = new Expense(SplitFactory.getSplitStrategy(SplitType.EQUAL));
        List<User> userList = Arrays.asList(user1,user2,user3,user4);
        expense.addExpense(userList, BigDecimal.valueOf(1500), user1);

        Expense expense2 = new Expense(SplitFactory.getSplitStrategy(SplitType.EQUAL));
        List<User> userList2 = Arrays.asList(user1,user2);
        expense2.addExpense(userList2, BigDecimal.valueOf(2000), user1);
    }
}
