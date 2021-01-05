package python;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.google.common.base.Preconditions;
import org.python.util.PythonInterpreter;

import java.io.ByteArrayInputStream;

/**
 * @Author jiaxingwu
 * @Time 2018/10/10 15:06
 * @Description dreamjxw/CS-Notes
 */
public class JythonUtils {
    public void usePythonMethodForFile(String filePath, String data) {

        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(filePath);
        PyFunction pyFunction = interpreter.get("_calculator_fun", PyFunction.class);
        PyObject pyObject = pyFunction.__call__(Py.newString(data));
        System.out.println(pyObject.toString());
    }

    public void usePythonMethodForStream(String script, String data) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile(new ByteArrayInputStream(script.getBytes()));
        PyFunction pyFunction = interpreter.get("_calculator_fun", PyFunction.class);
        PyObject pyObject = pyFunction.__call__(Py.newString(data));
        System.out.println(pyObject.toString());
    }
}
