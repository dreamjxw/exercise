package com.jxw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[][] data = new int[3][2];
        data[0][0] = 0;
        data[0][1] = 3;
        data[1][0] = 2;
        data[1][1] = 4;
        data[2][0] = 1;
        data[2][1] = 3;
        long l = new Main().maximumImportance(5, data);
        System.out.println(l);
    }

    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            Integer key = (int) num.charAt(i) - 48;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for (int i = 0; i < num.length(); i++) {
            Integer temp = map.getOrDefault(i, 0);
            Integer value = (int) num.charAt(i) - 48;
            if (!temp.equals(value)) {
                return false;
            }
        }
        return true;
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < senders.length; i++) {
            Set<Integer> set = map.get(senders[i]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(i);
            map.put(senders[i], set);
        }
        int resultTemp = 0;
        String resultName = "";
        for (Map.Entry<String, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            if (value == null) {
                continue;
            }
            int temp = 0;
            for (Integer item : value) {
                temp += messages[item].split(" ").length;
            }

            if (temp > resultTemp) {
                resultTemp = temp;
                resultName = entry.getKey();
            }
            if (temp == resultTemp && entry.getKey().compareTo(resultName) > 0) {
                resultName = entry.getKey();
            }
        }
        return resultName;
    }


    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] road : roads) {
            map.merge(road[0], 1L, Long::sum);
            map.merge(road[1], 1L, Long::sum);
        }

        List<Map.Entry<Integer, Long>> entrySet = new ArrayList<>(map.entrySet());
        Collections.sort(entrySet, new MyComparator());

        Map<Integer, Integer> mapping = new HashMap<>();
        for (Map.Entry<Integer, Long> entry : entrySet) {
            mapping.put(entry.getKey(), n--);
        }
        long result = 0L;
        for (int[] road : roads) {
            long road0 = mapping.get(road[0]);
            long road1 = mapping.get(road[1]);
            result += (road0 + road1);
        }
        return result;

    }

    static class MyComparator implements Comparator<Map.Entry<Integer, Long>> {
        @Override
        public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    }
}