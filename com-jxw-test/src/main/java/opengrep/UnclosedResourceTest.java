package opengrep;

import java.io.FileInputStream;
import java.io.IOException;

public class UnclosedResourceTest {
    public void readFile(String path) throws IOException {
        // 高危：文件流未关闭，造成资源泄漏
        FileInputStream fis = new FileInputStream(path);
        byte[] buffer = new byte[1024];
        fis.read(buffer);
    }
}