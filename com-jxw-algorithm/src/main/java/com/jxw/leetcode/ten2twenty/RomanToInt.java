package com.jxw.leetcode.ten2twenty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiaxingwu
 * @date 2019/8/8 19:35
 * @Description 第十三题  罗马数字转整数
 */
public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String str = "III";
        System.out.println(romanToInt.romanToInt(str));
    }


    private static Map<Character, Integer> map = new HashMap<>(7);

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0, left;
        for (int i = 0; i < s.length(); i++) {
            left = map.get(s.charAt(i));
            if ((i + 1) < s.length() && left < map.get(s.charAt(i + 1))) {
                result += (map.get(s.charAt(i + 1)) - left);
                i++;
                continue;
            }
            result += left;
        }
        return result;
    }
}
