package com.moringa.mc34robolectrictest;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//@Run with is required only if you use a mix of junit3 and junit 4
//@SmallTest, @MediumTest, and @LargeTest: Classify how long a test should take to run, and consequently, how frequently you can run the test.
// Test Refference <!- https://developer.android.com/training/testing/junit-runner ->
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
            .perform(typeText("George"), closeSoftKeyboard())
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

    //Checking if text to be passed to next activity is successfull
    @Test
    public void checkIfEditedTextIsSuccessfullyPassedToRegisterActivity(){
    String name = "George";
    onView(withId(R.id.editText))
            .perform(typeText(name), closeSoftKeyboard());

    onView(withId(R.id.secondActivityButton))
            .perform(click());
    //checking if text was changed.
    onView(withId(R.id.registerTextView))
            .check(matches(withText("In Register Activity " + name)));

    }
}
