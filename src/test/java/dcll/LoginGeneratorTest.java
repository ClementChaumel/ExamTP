package dcll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginService loginService;
    LoginGenerator generator;

    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        generator = new LoginGenerator(loginService);
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() throws Exception {
        assertEquals("PDUR", generator.generateLoginForNomAndPrenom("Durand", "Paul"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomExistant() throws Exception {
        assertEquals("JROL1", generator.generateLoginForNomAndPrenom("Rolling", "Jean"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomAccent() throws Exception {
        assertEquals("PDUR", generator.generateLoginForNomAndPrenom("Dùrand", "Paul"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomNomCourt() throws Exception {
        assertEquals("PDU", generator.generateLoginForNomAndPrenom("Du", "Paul"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomDeuxieme() throws Exception {
        assertEquals("JRAL2", generator.generateLoginForNomAndPrenom("Ralling", "John"));
    }


}