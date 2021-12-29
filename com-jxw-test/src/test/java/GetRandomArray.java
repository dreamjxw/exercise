import java.util.Arrays;

/**
 * @Author jiaxingwu
 * @Time 2018/12/10 10:09
 * @Description
 */
public class GetRandomArray {
    public static void main(String[] args) {
        int n = 6;
        int count = 6;
        int number[] = new int[n];
        int result[] = new int[count];
        for (int i = 0; i < n; i++) {
            number[i] = i + 1;
        }
        for (int i = 0; i < count; i++) {
            int key = (int) (Math.random() * n);
            result[i] = number[key];
            number[key] = number[n - 1];
            n--;
        }
        System.out.println(Arrays.toString(result));
    }
}
