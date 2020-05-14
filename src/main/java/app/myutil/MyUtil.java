package app.myutil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyUtil {

    public static String getCurrentDateTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return time.format(format);
    }
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }


    public static void main(String[] args) {
//        String password = "12345678";
//        String encrytedPassword = encrytePassword(password);
//
//        System.out.println("Encryted Password: " + encrytedPassword);
    }
}
