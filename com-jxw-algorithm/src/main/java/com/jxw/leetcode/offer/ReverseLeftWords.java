package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/3 15:19
 * @description https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        ReverseLeftWords leftWords = new ReverseLeftWords();

        String abcdefg1 = leftWords.reverseLeftWords("abcdefg", 2);
        System.out.println(abcdefg1);
    }


    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }

        n = n % s.length();
        char[] chars = s.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }


    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char a = chars[left];
            chars[left] = chars[right];
            chars[right] = a;
            left++;
            right--;
        }
    }
}
