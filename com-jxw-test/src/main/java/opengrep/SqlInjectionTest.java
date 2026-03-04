package opengrep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlInjectionTest {
    // 模拟用户输入（可控参数，可被恶意构造）
    public void queryUser(String userId) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
        Statement stmt = conn.createStatement();
        // 高危：直接拼接参数，触发SQL注入规则告警
        String sql = "SELECT * FROM user WHERE id = " + userId;
        stmt.executeQuery(sql);
    }
}