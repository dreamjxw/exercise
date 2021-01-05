package python;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.io.*;

/**
 * @Author jiaxingwu
 * @Time 2018/10/9 20:24
 * @Description
 */
public class PythonService<S> {
    private static final Logger log = LoggerFactory.getLogger(PythonService.class);
//    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final static String CMD_HEAD = "python";
    private final static String PYTH_PATH = "C:\\Users\\jiaxingwu\\Desktop\\python.py";

    public ResponseParam service(String script, S param) {
        if (!saveStringAsFile(script)) {
            log.error("生成python文件失败");
            return ResponseParam.resultFail(script, "生成python文件失败");
        }
        String result = perform(param.toString());
        if (StringUtils.isEmpty(result)) {
            log.error("解析python文件失败");
            return ResponseParam.resultFail(script, "解析python文件失败");
        }
        if (!deleteFile()) {
            log.error("删除python文件失败");
            return ResponseParam.resultFail(script, "删除python文件失败");
        }
        return ResponseParam.resultSuccess(result);
    }

    private boolean saveStringAsFile(String script) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PYTH_PATH);
            fileOutputStream.write(script.getBytes());
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String perform(String data) {
        String[] param = {CMD_HEAD, PYTH_PATH, data};
        try {
            Process exec = Runtime.getRuntime().exec(param);
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "UTF-8"));
            String readLine = reader.readLine();
            exec.waitFor();
            reader.close();
            exec.destroy();
            return readLine;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }

    }


    private boolean deleteFile() {
        File file = new File(PYTH_PATH);
        return file.delete();
    }
}
