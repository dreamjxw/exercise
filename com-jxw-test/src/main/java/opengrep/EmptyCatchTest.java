package opengrep;

public class EmptyCatchTest {
    public void testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            // 高危：空catch块，不打印日志、不抛出异常
        }
    }
}