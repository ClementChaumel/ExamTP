package dcll;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LoginServiceTest {


    LoginService service;
    String[] loginsExistants = {"paul", "tom", "pierre"};

    @Before
    public void setUp() throws Exception {
        service = new LoginService(loginsExistants);

    }

    @Test
    public void testLoginExists() throws Exception {
        assertTrue(service.loginExists("paul"));
        assertFalse(service.loginExists("Clement"));

    }

    @Test
    public void testAddLogin() throws Exception {
        assertFalse(service.loginExists("Toto"));
        service.addLogin("Toto");
        assertTrue(service.loginExists("Toto"));

    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        ArrayList<String> logins = new ArrayList<String>();
        logins.add("paul");
        logins.add("pierre");
        assertEquals(logins, service.findAllLoginsStartingWith("p"));

    }

    @Test
    public void testFindAllLogins() throws Exception {
        ArrayList<String> logins = new ArrayList<String>();
        logins.add("paul");
        logins.add("pierre");
        logins.add("tom");
        assertEquals(logins, service.findAllLogins());

    }
}