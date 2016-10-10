package com.sagarrathod.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 *
 * @author Sagar Rathod
 * @version 1.0
 *
 * Unit tests the endpoint async task.
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest implements ResultCallbackListener{

    private final String EMPTY_STRING = "";

    /**
     * Tests the endpoint asynctask to check that it does not return
     * empty joke response.
     */
    @Test
    public void testAsyncTask(){

            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(this, null);
            endpointsAsyncTask.execute(EMPTY_STRING);
    }

    /**
     * Result callback handler for endpointsAsyncTask
     * @param response
     */
    @Override
    public void resultCallback(String response) {
        assertNotEquals(response, EMPTY_STRING);
    }
}