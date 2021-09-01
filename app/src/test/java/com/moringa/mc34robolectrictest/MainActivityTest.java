package com.moringa.mc34robolectrictest;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

//This configures your android to ignore the 29 and above api version.
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

    //Simple Robolectric test
    @Test
    public void confirmIfTexViewIsthere(){
        TextView mainactivitytextview = mainActivityTest.findViewById(R.id.mainActivityTextView);
        assertNotNull("The Hello text view could not be found", mainactivitytextview);
        assertTrue("Hello World!".equals(mainactivitytextview.getText().toString()));
    }
    //Robolectric test using shadows
    //Shadows are Classes that modify or extend the behavior of a class in the Android SDK.
    @Test
    public void confirmIfNextActivityButton_onClickWorks(){
        mainActivityTest.findViewById(R.id.secondActivityButton).performClick();
        Intent expectedIntent = new Intent(mainActivityTest, RegisterActivity.class);
        ShadowActivity shadowActivity = Shadows.shadowOf(mainActivityTest);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
