package opengrep;

public class CommandInjectionTest {
    public void execSystemCmd(String input) throws Exception {
        // 高危：直接使用用户输入执行系统命令
        Runtime.getRuntime().exec("cat " + input);
    }
}