package ren.yueh.crap;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() throws IOException {
        super(Application.class);

    }
}