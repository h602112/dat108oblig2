package dat108.hvl.no.fest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class HashPassword {
    public static void main(String[] args) {
        String[] somePasswords = {"hei", "Hallaien", "pwd123", "Peace&Love", "4everSecure"};

    }

    public static byte[] passwordAsByte(String p) throws UnsupportedEncodingException {
        return p.getBytes("UTF-8");
    }




}




