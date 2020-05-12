package dao;

import models.Department;
import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    private Connection conn;
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "paul", "Negotiator");
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao();
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    @Test
    public void addingNewsSetsId() throws Exception {
        News testNews = new News("health","paul",6);
        assertEquals(1, testNews.getId());
    }
    @Test
    public void getAll() throws Exception {
        News news1 = new News("health","paul",6);
        News news2 = new News("health","paul",6);
        assertEquals(2, newsDao.getAll().size());
    }
    @Test
    public void deleteById() throws Exception {
        News testNews = new News("health","paul",6);
        News otherNews = new News("health","paul",6);
        assertEquals(2, newsDao.getAll().size());
        newsDao.deleteById(testNews.getId());
        assertEquals(1, newsDao.getAll().size());
    }
    @Test
    public void clearAll() throws Exception {
        News testNews = new News("health","paul",6);
        News other = new News("health","paul",6);
        newsDao.clearAll();
        assertEquals(0, newsDao.getAll().size());
    }

}