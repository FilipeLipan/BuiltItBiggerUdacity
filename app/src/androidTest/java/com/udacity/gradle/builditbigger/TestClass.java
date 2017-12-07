package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;

import io.reactivex.observers.TestObserver;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestClass {

    @Test
    public void verify_if_downloaded_joke_is_not_empty() throws Exception{

        TestObserver<String> observer = new TestObserver<>();
        MainActivity.getJoke().subscribe(observer);
        observer.assertNoErrors();
        assertThat(observer.values().get(0), is(not(isEmptyString())));
    }
}