package dat108.hvl.no.fest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

    public byte[] passwordAsByte(String p) throws UnsupportedEncodingException {
        return p.getBytes("UTF-8");
    }

    public byte[] hashPassword(String p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(passwordAsByte(p));
    }
}




