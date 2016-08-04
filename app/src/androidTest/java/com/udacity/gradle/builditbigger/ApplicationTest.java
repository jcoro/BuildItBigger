package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.udacity.gradle.builditbigger.callbacks.AsyncTaskCompleteListener;

import java.util.concurrent.CountDownLatch;
/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    CountDownLatch mSignal = null;
    AsyncTaskCompleteListener mListener = null;
    String mResult = null;


    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        mSignal.countDown();
    }

    public void testAsyncTask() throws InterruptedException {
        new EndpointsAsyncTask(new AsyncTaskCompleteListener<String>() {
            @Override
            public void onTaskComplete(String result)
            {
                mResult = result;
                mSignal.countDown();
            }
        }).execute();
        mSignal.await();
        assertTrue(mResult != null && !mResult.isEmpty());

    }
}