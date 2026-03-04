package opengrep;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class WeakCryptoTest {
    public void weakHash() throws Exception {
        // 高危：MD5属于弱哈希算法
        MessageDigest md = MessageDigest.getInstance("MD5");
    }

    public void weakEncrypt() throws Exception {
        // 高危：DES属于弱对称加密算法
        KeyGenerator.getInstance("DES");
        Cipher.getInstance("DES/ECB/PKCS5Padding");
    }
}