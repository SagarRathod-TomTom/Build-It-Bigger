package com.sagarrathod.test;

import com.sagarrathod.jokes.Jokes;

import org.junit.Test;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Sagar Rathod
 * @version 1.0
 *
 * Unit tests the java joke api.
 */
public class JokeTest {

    /**
     * Tests the not null and not empty joke response.
     */
    @Test
    public void testJoke(){
         Jokes jokes = Jokes.getInstance();
         String joke = jokes.getRandomJoke();

         assertNotEquals(joke,null);
         assertNotEquals(joke, "");
    }

}
