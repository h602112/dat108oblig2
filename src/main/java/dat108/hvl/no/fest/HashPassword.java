package dat108.hvl.no.fest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class HashPassword {

    public byte[] passwordAsByte(String p) throws UnsupportedEncodingException {
        return p.getBytes("UTF-8");
    }

    public byte[] salt() {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    public byte[] saltAndPassword(byte[] salt, byte[] password) {
        byte[] saltAndPassword = new byte[salt.length + password.length];
        System.arraycopy(salt, 0, saltAndPassword, 0, salt.length);
        System.arraycopy(password, 0, saltAndPassword, salt.length, password.length);
        return saltAndPassword;
    }
    //this function takes a string as parameter, adds a salt to it, hashes the salt and string 1000 times
    //then converts it back to string with a base 64 encoder
    public String hashPassword(String p) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] salt = salt();
        byte[] bytePassword = passwordAsByte(p);
        byte[] saltAndPassword = saltAndPassword(salt, bytePassword);
        byte[] digest = saltAndPassword;
        for (int i = 0; i < 1000; i++) {
            digest = md.digest(digest);
        }
        return Base64.getEncoder().encodeToString(digest);
    }
}




