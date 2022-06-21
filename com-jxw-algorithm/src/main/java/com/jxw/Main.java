package com.jxw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        String str = "10011111110010111011";
        String str = "011110110111111";
        int i = main.minFlipsMonoIncr(str);
        System.out.println(i);
    }

    public int minFlipsMonoIncr(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '1') {
                list.add(i);
            }
        }
        int result = s.length();
        for (Integer temp : list) {
            int result01 = 0;
            int result0 = 0;
            int result1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i < temp && s.charAt(i) == '1') {
                    result01++;
                }
                if (i >= temp && s.charAt(i) == '0') {
                    result01++;
                }
                if (s.charAt(i) == '1') {
                    result1++;
                }
                if (s.charAt(i) == '0') {
                    result0++;
                }
            }
            result = Math.min(result, Math.min(result01, Math.min(result0, result1)));
        }
        return result;
    }


    public int smallestDistancePair(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if (map.containsKey(abs)) {
                    map.put(abs, map.get(abs) + 1);
                } else {
                    map.put(abs, 1);
                }
            }
        }
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (temp + entry.getValue() >= k) {
                return entry.getKey();
            }
            temp += entry.getValue();
        }
        return 0;
    }

}