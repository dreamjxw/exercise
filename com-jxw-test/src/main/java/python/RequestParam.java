package python;

import lombok.Data;
import lombok.ToString;

/**
 * @Author jiaxingwu
 * @Time 2018/10/9 20:25
 * @Description
 */
@Data
@ToString
public class RequestParam {
    /**
     * python脚本
     */
    private String script;
    /**
     * 请求数据
     */
    private Object data;

}
