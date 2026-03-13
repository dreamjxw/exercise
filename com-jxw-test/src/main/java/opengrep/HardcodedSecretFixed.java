package opengrep;

public class HardcodedSecretFixed {
    // 安全写法：从环境变量获取敏感配置
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    private static final String API_KEY = System.getenv("API_KEY");
}