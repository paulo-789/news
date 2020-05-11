package models;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class NewsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getContentCorrectContent()throws Exception{
        News testNews = new News ("staff","paul");
        assertEquals("staff",testNews.getContent());
    }
    @Test
    public void getWrittenBy()throws Exception{
        News testNews = new News("staff","paul");
        assertEquals("paul",testNews.getWrittenBy());
    }
    @Test
    public void setContentCorrectly()throws Exception{
        News testNews = new News("staff","paul");
        testNews.setContent("staff");
        assertNotEquals("paul",testNews.getContent());
    }
    @Test
    public void setWrittenCorrectly()throws Exception{
        News testNews = new News("staff","paul");
        testNews.setWrittenBy("paul");
        assertNotEquals("staff",testNews.getWrittenBy());
    }

}