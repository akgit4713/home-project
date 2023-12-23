package com.homeproject.homeproject.splitwise;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ISplit {
    Map<User, BigDecimal> calculate(List<User> users, BigDecimal amount);
}
