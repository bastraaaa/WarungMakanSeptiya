package view;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // Bisa diganti BCrypt untuk keamanan lebih baik
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b)); // Ubah byte ke hex string
            }

            return sb.toString(); // Hasil hash
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

