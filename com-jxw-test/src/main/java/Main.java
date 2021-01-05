/**
 * @author jiaxingwu
 * @date 2020/11/26 16:35
 * @description
 */
public class Main {

    public static void main(String[] args) {
        int fib = fib(10);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int i, j = 1, k = 1;
        for (int m = 2; m < n; m++) {
            i = j;
            j = k;
            k = i + j;
        }
        return k;
    }


}
