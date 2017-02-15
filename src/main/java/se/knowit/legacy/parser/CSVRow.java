package se.knowit.legacy.parser;

import se.knowit.legacy.Personnummer;

public class CSVRow {
    private String firstname;
    private String lastname;
    private Personnummer personnummer;
    private String email;

    public CSVRow(String firstname, String lastname, Personnummer personnummer, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.personnummer = personnummer;
        this.email = email;
    }

    public CSVRow() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Personnummer getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(Personnummer personnummer) {
        this.personnummer = personnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CSVRow{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", personnummer=" + personnummer +
                ", email='" + email + '\'' +
                '}';
    }

    public String toCsv() {
        return String.format("%s;%s;%s;%s", this.firstname, this.lastname, this.personnummer.getPersonnummer(), this.getEmail());
    }
}
