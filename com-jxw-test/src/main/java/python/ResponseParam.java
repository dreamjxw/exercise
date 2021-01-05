package python;

import lombok.Data;
import lombok.ToString;

/**
 * @Author jiaxingwu
 * @Time 2018/10/9 20:31
 * @Description
 */
@Data
@ToString
public class ResponseParam<T> {
    private Boolean isSuccess;
    private String errorMess;
    private T data;

    private ResponseParam(Boolean isSuccess, String errorMess, T data) {
        this.isSuccess = isSuccess;
        this.errorMess = errorMess;
        this.data = data;
    }

    public static <T> ResponseParam<T> resultSuccess(T data) {
        return new ResponseParam<>(true, "", data);
    }

    public static <T> ResponseParam<T> resultFail(T data, String errorMess) {
        return new ResponseParam<>(false, errorMess, data);
    }
}
