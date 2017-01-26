package se.knowit.legay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Legacy {

    public static void main(String[] args) throws Exception {
        System.out.println("start");

        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str = null;
        int first = 0;
        while ((str = br.readLine()) != null) {
            if(first == 0) {
                first++;
                continue;
            }
            System.out.println(str);
            String[] cls = str.split(";");
            //valid email
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            /**

             SPARA TILL SEN!!!


             Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

             if (!match.matches()) {
             System.out.println(cls[3]); // bort
                        throw new Exception("FEL MAIL");
             }
             */
            Matcher match = pattern.matcher(cls[3]);

            if (!match.matches()) {
                System.out.println(cls[3]); // bort
                throw new Exception("FEL MAIL");
            }

            //valid
        }

    }
}
