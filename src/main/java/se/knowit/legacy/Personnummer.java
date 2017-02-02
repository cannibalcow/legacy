package se.knowit.legacy;

public class Personnummer {

    private String personnummer;

    public boolean validera(String personnummer) {
        System.out.println(personnummer);
        if (personnummer.contains("-")) {
            if (personnummer.startsWith("1") || personnummer.startsWith("2")) {
                if (personnummer.charAt(4) == '0' || personnummer.charAt(4) == '1') {
                    if (personnummer.charAt(5) == '1' || personnummer.charAt(5) == '2' || personnummer.charAt(5) == '3') {
                        Integer d = new Integer(personnummer.substring(7, 8));
                        if (d > 0 && d < 32) {
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
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getPersonnummer() {
        return personnummer;
    }
}
