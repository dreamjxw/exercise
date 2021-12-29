import java.util.Arrays;

/**
 * @author jiaxingwu
 * @date 2019/11/11 17:21
 * @Description
 */
public class AlgoTest {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 2, 4, 6, 3};
        int j;
        for (int i = 1; i < a.length; i++) {
            int i1 = a[i];
            for (j = i; j > 0 && a[j - 1] > i1; j--) {
                a[j] = a[j - 1];
            }
            a[j] = i1;
        }
        System.out.println(Arrays.toString(a));
    }
}
