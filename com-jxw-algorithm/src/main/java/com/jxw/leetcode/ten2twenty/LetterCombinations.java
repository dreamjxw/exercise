package com.jxw.leetcode.ten2twenty;

import java.util.*;

/**
 * @author jiaxingwu
 * @date 2019/8/23 18:10
 * @Description 第十七次  电话号码的字母组合
 */
public class LetterCombinations {
    private static Map<Integer, String> map = new HashMap(8);

    static {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }

    /**
     * 非递归    采用队列
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (Objects.isNull(digits) || digits.isEmpty()) {
            return list;
        }
        if (digits.length() == 1) {
            char[] chars = map.get(digits.charAt(0) - '0').toCharArray();
            for (Character character : chars) {
                list.add(character + "");
            }
            return list;
        }
        list.add("");
        String head;
        char[] characters;
        for (int i = 0; i < digits.length(); i++) {
            while (list.peek().length() == i) {
                head = list.remove();
                characters = map.get(digits.charAt(i) - '0').toCharArray();
                for (Character character : characters) {
                    list.add(head + character);
                }
            }
        }

        return list;
    }
}
