package com.jxw.common;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author jiaxingwu
 * @date 2020/5/19 18:28
 * @Description
 */
public class 最长不重复子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int maxLength = 0;
        int start = 0;
        int n = str.length();
        int[] next = new int[n];
        int[] a = new int[n + 1];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < n; k++) {
            map.put(str.charAt(k), n);
        }
        a[n] = n;
        for (int i = n - 1; i >= 0; i--) {
            next[i] = map.get(str.charAt(i));
            map.put(str.charAt(i), i);
            if (next[i] < a[i + 1])
                a[i] = next[i];
            else
                a[i] = a[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (a[i] - i > maxLength) {
                maxLength = a[i] - i;
                start = i;
            }
        }
        System.out.println(str.substring(start, start + maxLength));
    }
}
