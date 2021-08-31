package com.moringa.mc34robolectrictest;

import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;

//This configures your android to ignore the api version.
@Config(sdk = {Build.VERSION_CODES.O_MR1})

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mainActivityTest;
    @Before
    public void setUp(){
        mainActivityTest = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void confirmIfTexViewIsthere(){
        TextView mainactivitytextview = mainActivityTest.findViewById(R.id.mainActivityTextView);
        assertTrue("Hello World!".equals(mainactivitytextview.getText().toString()));
    }
}
