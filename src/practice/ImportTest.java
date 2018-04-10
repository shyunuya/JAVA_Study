package practice;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ImportTest {
    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

        System.out.println("Today's date = " + date.format(today));
        System.out.println("Current time = " + time.format(today));
    }
}
