package proxy;

/**
 * @Author jiaxingwu
 * @Time 2018/12/12 16:45
 * @Description
 */
public interface AccountService {
    default String getUserPin(String a) {
        return a;
    }
}
