package opengrep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VulnerableCodeExample {

    // 1. SQL注入漏洞
    public void unsafeQuery(String userInput) {
        String sql = "SELECT * FROM users WHERE username = '" + userInput + "'";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
