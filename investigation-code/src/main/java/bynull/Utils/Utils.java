package bynull.Utils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by null on 4/13/14.
 */
public class Utils {

    public static void print(Object msg) {
        Date time = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss,SSS");

        System.out.println(MessageFormat.format("[{0}] {1}", dateFormat.format(time), msg));
    }
}
