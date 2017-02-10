package se.knowit.legacy;

import org.junit.Test;

/**
 * Created by heldt on 2017-02-02.
 */
public class PersonnummerTest {

    @Test
    public void createTest() {
        Personnummer p = new Personnummer();
        p.setPersonnummer("19820930-1234");
    }
}