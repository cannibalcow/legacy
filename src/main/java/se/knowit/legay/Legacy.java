package se.knowit.legay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Legacy {

    public static void main(String[] args) {
        System.out.println("start");
        int cent = 1600;
        File file = new File(args[0]);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("error");
            return;
        }

        String str = null;
        int first = 0;

        List<String> rs = new ArrayList<>();

        try {
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

                 SPARA TILL SEN OM OVE KOMMER TILLBAKS!!!

                 Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

                 if (!match.matches()) {
                 System.out.println(cls[3]); // bort
                            throw new Exception("FEL MAIL");
                 }
                 */
                Matcher match = pattern.matcher(cls[3]);

                if (!match.matches()) {
                    System.out.println(cls[3]); // bort
                    System.out.println("Fel i epost");
                    throw new RadFel("FEL");
                }

                Personnummer pv = new Personnummer();
                if(pv.validPersonnummer(cls[2])) {
                    System.out.println("fel personnummer");
                }

                if(cls[0].equals('A') || cls[0].equals('B') || cls[0].equals('F') || cls[0].equals('D')) {
                    if(cls[1].equals("") || cls[1] == null) {
                        int a = new Integer(cls[3].substring(0, 3)) - cent;
                        if(a <= 18) {
                            rs.add(cls[0] + ";" + cls[1] + ";" + cls[2] + ";" + cls[3]);
                        }
                    }
                } else {
                    if(!cls[1].equals("") || cls[1] != null) {
                        int a = new Integer(cls[3].substring(0, 3)) - cent;
                        if(a <= 18) {
                            rs.add(cls[0] + ";" + cls[1] + ";" + cls[2] + ";" + cls[3]);
                        }
                    }
                }
            }
        } catch (IOException e) {
        } catch (RadFel radFel) {
            radFel.printStackTrace();
        }

        for(int i  = 0; i < rs.size(); i++ ) {
            System.out.println(rs.get(i));
        }
    }
}
