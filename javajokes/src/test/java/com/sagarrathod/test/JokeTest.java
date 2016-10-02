package com.sagarrathod.test;

import com.sagarrathod.jokes.Jokes;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by samsung on 02-Oct-2016.
 */

public class JokeTest {

    @Test
    public void testJoke(){

        Jokes jokes = Jokes.getInstance();
         String joke = jokes.getRandomJoke();
        assertNotEquals(joke,null);
    }

}
