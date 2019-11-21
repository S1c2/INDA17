

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

//Answer to 7.13
public class CommentTest
{
    Comment comment;
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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
     * checks whether the author and rating details are stored correctly after creation
     */
    //Answer to 7.18
    
    @Test
    public void testAuthorAndRatingDetails()
    {  
        comment = new Comment("Sabrina", "Good", 4);
        assertEquals("Sabrina", comment.getAuthor());
        assertEquals(4, comment.getRating());
    }
    
    /**
     * checks whether upvote method works as expected
     */
    //Answer to 7.18
    @Test
    public void testUpVote()
    {  
        comment = new Comment("Sabrina", "Good", 4);
        comment.upvote();
        assertEquals(1,comment.getVoteCount());
    }
    
    /**
     * checks whether downvote method works as expected
     */
    //Answer to 7.18
    @Test
    public void testDownVote()
    {  
        comment = new Comment("Sabrina", "Good", 4);
        comment.downvote();
        assertEquals(-1,comment.getVoteCount());
    }
    
    
    
    
   
}
