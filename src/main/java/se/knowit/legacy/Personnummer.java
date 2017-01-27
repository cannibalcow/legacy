package se.knowit.legay;

public class Personnummer {

    public boolean validPersonnummer(String personnummer) {
        if (personnummer.contains("-")) {
            if (personnummer.startsWith("1") || personnummer.startsWith("2")) {
                if (personnummer.substring(1, 2).startsWith("1") ||
                        personnummer.substring(1, 2).startsWith("2") ||
                        personnummer.substring(1, 2).startsWith("3") ||
                        personnummer.substring(1, 2).startsWith("4") ||
                        personnummer.substring(1, 2).startsWith("5") ||
                        personnummer.substring(1, 2).startsWith("6") ||
                        personnummer.substring(1, 2).startsWith("7") || personnummer.substring(1, 2).startsWith("8") ||
                personnummer.substring(1, 2).startsWith("9")){

                    if (new Integer(personnummer.split("-")[1]) > 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
