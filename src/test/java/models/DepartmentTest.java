package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNameReturnsCorrectName()throws Exception{
        Department testDepartment = new Department("cleners","workers",4);
        assertEquals("cleners",testDepartment.getName());
    }
    @Test
    public void getDescriptionCorrectDescription()throws Exception{
        Department testDepartment = new Department("cleners","workers",4);
        assertEquals("workers",testDepartment.getDescription());
    }
    @Test
    public void getNumberOfStaff()throws  Exception{
        Department testDepartment = new Department("cleners","workers",4);
        assertEquals(4,testDepartment.getNumberOfStaff());
    }
    @Test
    public void setNameCorrectly()throws Exception{
        Department testDepartment = new Department("cleners","workers",4);
        testDepartment.setName("cleaners");
        assertNotEquals("workers",testDepartment.getName());
    }
    @Test
    public void setDescriptionCorrectly()throws Exception{
        Department testDepartment = new Department("cleners","workers",4);
        testDepartment.setDescription("workers");
        assertNotEquals("cleaners",testDepartment.getDescription());
    }
    @Test
    public void setNumberOfStaffCorrectly()throws Exception{
        Department testDepartment = new Department("cleners","workers",4);
        testDepartment.setNumberOfStaff(4);
        assertNotEquals("7",testDepartment.getNumberOfStaff());
    }

}