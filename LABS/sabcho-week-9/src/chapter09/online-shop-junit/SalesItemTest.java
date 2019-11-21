import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    
    SalesItem salesIte1;
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        salesIte1 = new SalesItem("item", 1000);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
       
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }
    
    /**
     * a test to check that addComment returns false when a comment from the same author already exists
     */
    //Answer to 7.15
    @Test
    public void testSameAuthor()
    {
       
        assertEquals(true, salesIte1.addComment("Sabrina Chowdhury", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(false, salesIte1.addComment("Sabrina Chowdhury", "Wonderful", 5));
    }
    
    /**
     * a test that performs negative testing on the boundaries of the rating range.
     */
    //Answer to 7.16
    @Test
    public void testBoundariesOfRating()
    {
       
        assertEquals(false, salesIte1.addComment("Sabrina Chowdhury", "This book is great. I perform brain surgery every week now.", 0));
        assertEquals(false, salesIte1.addComment("Sab Chow", "Wonderful", 6));
    }
    

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
       
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
      
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }

    @Test
    public void addComment()
    {
        
        assertEquals(true, salesIte1.addComment("Fred", "Great - I perform brain surgery every week now!", 4));
    }

    @Test
    public void testInitialPrice()
    {
        
        assertEquals(1000, salesIte1.getPrice());
    }
    
    
}




