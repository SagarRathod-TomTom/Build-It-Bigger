package com.sagarrathod.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest implements ResultCallbackListener{

    private final String EMPTY_STRING = "";

    @Test
    public void testAsyncTask(){

            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(this);
            endpointsAsyncTask.execute(EMPTY_STRING);
    }

    @Override
    public void resultCallback(String response) {
        assertNotEquals(response, EMPTY_STRING);
    }
}