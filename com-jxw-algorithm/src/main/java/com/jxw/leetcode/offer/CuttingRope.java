package com.jxw.leetcode.offer;

/**
 * @author jiaxingwu
 * @date 2021/2/20 11:00
 * @description https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CuttingRope {


    public static void main(String[] args) {
        int rope = new CuttingRope().cuttingRope(10);
        System.out.println(rope);
    }

    /**
     * x,y(x>y>0)代表将一段绳子分为2截不同长度，假设x,y越接近max值越大
     * 则 n=(x+y)    max=x*y
     * 同样的   n=(x+1)+(y-1)  max=x*y-(x+y)-1<x*y
     * 说明假设正确   x与y越接近  乘积越大
     * <p>
     * <p>
     * 则假设将长度为n的绳子，分成每段x长度，则乘积表达式为 y=(n/x)^x ,求y最大时，x的取值
     * Iny=x*In(n/x)=x(Inn-Inx)
     * 两边对x求导：
     * y`=(In(n/x)-1)*(n/x)^x
     * <p>
     * 令y`=0  ==> x=e/n   所以每段绳子长度n/x=e ≈ 3
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long count = 1;
        while (n > 4) {
            n -= 3;
            count = count * 3 % 1000000007;
        }
        count = count * n;

        return (int) (count % 1000000007);

    }
}
