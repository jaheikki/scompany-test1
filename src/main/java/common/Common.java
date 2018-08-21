package common;

import org.joda.time.DateTime;

public class Common {

    public static String printMethodName() {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String line1 = ("\n*******************************************\n");
        String line2 = ("***** Method: " + methodName + " *****\n");
        String line3 = ("*******************************************\n");
        String line4 = (new DateTime()).toString();
        String printout = line1+line2+line3+line4;
        System.out.println(printout);
        return printout;

    }
}
