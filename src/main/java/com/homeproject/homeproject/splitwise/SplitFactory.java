package com.homeproject.homeproject.splitwise;

public class SplitFactory {
    public static ISplit getSplitStrategy(SplitType splitType){
        ISplit split = null;
        switch (splitType) {
            case EQUAL -> split = new EqualSplit();
            case PERCENT -> split = new PercentSplit();
            case UNEQUAL -> split = new UnequalSplit();
            default -> System.out.println("WRONG SPLIT STRATEGY!");
        }
        return split;
    }
}
