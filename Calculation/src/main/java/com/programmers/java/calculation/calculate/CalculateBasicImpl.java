package com.programmers.java.calculation.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class CalculateBasicImpl implements Calculate {

    @Override
    public Double cal(List<String> input) {
        List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/"));
        List<String> operatorPlusAndMinus = new ArrayList<>(Arrays.asList("+", "-"));
        List<Double> nums = new ArrayList<>();
        int temp = 1;

        for (int i = 0; i < input.size(); i++) {
            if (operatorPlusAndMinus.contains(input.get(i))) {
                if (Objects.equals(input.get(i), "-")) {
                    temp = -1;
                } else {
                    temp = 1;
                }
            } else if (operatorMulAndDiv.contains(input.get(i))) {
                int lastIndex = nums.size() - 1;
                double mulDivResult;
                if (Objects.equals(input.get(i), "*")) {
                    mulDivResult = nums.get(lastIndex) * Double.parseDouble(input.get(i+1));
                } else {
                    if (Double.parseDouble(input.get(i+1)) == 0) {
                        return null;
                    }
                    mulDivResult = nums.get(lastIndex) / Double.parseDouble(input.get(i+1));
                }
                nums.set(lastIndex, mulDivResult);
                i++;
            } else {
                Double result = temp * Double.parseDouble(input.get(i));
                nums.add(result);
            }
        }
        return nums.stream().mapToDouble(i -> i).sum();

        /*Double result = (double) 0;
        for (Double num : nums) {
            result += num;
        }
        return result;*/
    }
}
