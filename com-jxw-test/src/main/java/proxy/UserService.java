package proxy;

/**
 * @Author jiaxingwu
 * @Time 2018/12/12 15:20
 * @Description
 */
public interface UserService {
    public static String getUserPin() {
        return "system";
    }

    default String getUserPin(String a) {
        return a;
    }

    String save();
}
