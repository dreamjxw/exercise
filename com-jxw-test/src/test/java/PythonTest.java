import org.junit.Test;
import org.python.util.PythonInterpreter;
import python.JythonUtils;
import python.PythonService;
import python.ResponseParam;


import javax.script.ScriptException;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author jiaxingwu
 * @Time 2018/10/9 14:56
 * @Description
 */
public class PythonTest extends PythonService<Double> {
    private final static String CMD_HEAD = "python";
    private final static String PYTH_PATH = "C:\\Users\\jiaxingwu\\Desktop\\python.py";

    @Override
    public ResponseParam service(String script, Double param) {
        return super.service(script, param);
    }

    @Test
    public void Test() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        System.out.println(hostAddress);
    }

    @Test
    public void saveStringAsFile() {
        try {
            String file = "def fun_test(data1.txt, temp):\n" +
                    "    return data1.txt + temp\n" +
                    "\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    print(fun_test(100, 200))";
            byte[] bytes = file.getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(PYTH_PATH);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void perform() {
        String data = "10000";
        String[] param = {CMD_HEAD, PYTH_PATH, data};
        try {
            Process exec = Runtime.getRuntime().exec(param);
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "UTF-8"));
            System.out.println(reader.readLine());
            exec.waitFor();
            reader.close();
            exec.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void deleteFile() {
        File file = new File(PYTH_PATH);
        file.delete();
    }

    @Test
    public void jythonTest() {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.exec("print('Hello World!')");
    }

    @Test
    public void jythonUtilForFileTest() {
        String pythonPath = "";
        String data = "";
        JythonUtils jythonUtils = new JythonUtils();
        jythonUtils.usePythonMethodForFile(pythonPath, data);
    }
    @Test
    public void jythonUtilForStreamTest() {
        String script = "def check_param(data1.txt):\n" +
                "    try:\n" +
                "        data1.txt = float(data1.txt)\n" +
                "        return True, data1.txt\n" +
                "    except BaseException:\n" +
                "        return False, 0\n" +
                "\n" +
                "\n" +
                "def _calculator_fun(data1.txt):\n" +
                "    is_success, param = check_param(data1.txt)\n" +
                "    if not is_success:\n" +
                "        return \"Invalid request parameter\"\n" +
                "    if 0 <= param < 2000:\n" +
                "        return 0.02 * param\n" +
                "    elif 2000 <= param < 4000:\n" +
                "        return 0.02 * 2000 + 0.04 * (param - 2000)\n" +
                "    elif param > 4000:\n" +
                "        return 0.05 * 4000\n" +
                "    else:\n" +
                "        return \"Invalid request parameter\"";
        String data = "100";
        JythonUtils jythonUtils = new JythonUtils();
        jythonUtils.usePythonMethodForStream(script, data);
    }

}
