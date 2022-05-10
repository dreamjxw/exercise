/*
 * Copyright (C) 2022 Dream, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jiaxingwu
 * @date 2022/4/14 下午5:52
 * @description https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {
    private Map<Integer, Integer> itemMap;
    private List<Integer> itemList;

    public RandomizedSet() {
        itemMap = new HashMap<>();
        itemList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (itemMap.containsKey(val)) {
            return false;
        }
        itemList.add(val);
        itemMap.put(val, itemList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!itemMap.containsKey(val)) {
            return false;
        }
        int index = itemMap.get(val);
        int lastValue = itemList.get(itemList.size() - 1);
        itemList.set(index, lastValue);
        itemMap.put(lastValue, index);
        itemMap.remove(val);
        itemList.remove(itemList.size() - 1);
        return true;
    }

    public int getRandom() {
        int anInt = new Random().nextInt(itemList.size());
        return itemList.get(anInt);
    }

}
