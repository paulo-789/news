package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UsersTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNameCorrectly()throws Exception{
        Users testUsers = new Users("ken","head");
        assertEquals("ken",testUsers.getName());
    }
    @Test
    public void  getPossition()throws Exception{
        Users testUsers = new Users("ken","head");
        assertEquals("head",testUsers.getPosition());
    }
    @Test
    public void setNameCorrectly()throws Exception{
        Users testUsers = new Users("ken","head");
        testUsers.setName("ken");
        assertNotEquals("head",testUsers.getName());
    }
    @Test
    public void setPossitionCorrectly()throws Exception{
        Users testUsers = new Users("ken","head");
        testUsers.setPosition("head");
        assertNotEquals("ken",testUsers.getPosition());
    }


}