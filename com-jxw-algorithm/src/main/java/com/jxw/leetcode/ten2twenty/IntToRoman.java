package com.jxw.leetcode.ten2twenty;

import java.util.*;

/**
 * @author jiaxingwu
 * @date 2019/8/12 16:44
 * @Description 第十二题  整数转罗马数字
 */
public class IntToRoman {
    private static Map<Integer, String> map = new HashMap<>(7);

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }


    public String intToRoman(int num) {
        if (num > 3999) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int flag, count = 1000;
        while (count > 0) {
            flag = num / count;
            if (flag == 0) {
                count /= 10;
                continue;
            }
            String s = map.get(flag * count);
            if (s != null) {
                stringBuilder.append(s);
            } else {
                if (flag / 5 == 1) {
                    stringBuilder.append(map.get(count * 5));
                    flag -= 5;
                }
                String s1 = map.get(count);
                for (int i = 0; i < flag; i++) {
                    stringBuilder.append(s1);
                }
            }
            num %= count;
            count /= 10;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(421));
    }
}
