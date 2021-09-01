package com.moringa.mc34robolectrictest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//@Run with is required only if you use a mix of junit3 and junit 4
//SmallTest: this test doesn't interact with any file system or network.
//MediumTest: Accesses file systems on box which is running tests.
//LargeTest: Accesses external file systems, networks, etc.
//We use LargeTest annotation bcoz our test interacts with the networks and emulator.

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivityInstrumentedTest {
    //Telling our device to launch mainActivity before our tests start.
@Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

// withId(R.id.my_view) is a ViewMatcher

@Test
    public void validateNameEditText(){
    onView(withId(R.id.editText))
            .perform(typeText("George"))
            .check(matches(withText("George")));
}
//Checks if the email typed is the string to be typed.
@Test
    public void validateEmail(){
    onView(withId(R.id.editEmail))
            .perform(typeText("gokumu@gmail.com"))
            .check(matches(withText("gokumu@gmail.com")));
}
// click() is a ViewAction
// matches(isDisplayed()) is a ViewAssertion
//The below test checks if the edit text is displayable when clicked.
    @Test
    public void onClickDisplaysEmail(){
        onView(withId(R.id.editEmail))
                .perform(click())
                .check(matches(isDisplayed()));
    }
}
