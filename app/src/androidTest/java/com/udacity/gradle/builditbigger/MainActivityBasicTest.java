package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class MainActivityBasicTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class, true);

    @Test
    public void LaunchMainActivity_InstructionsAreDisplayed() {

        // Arrange
        final ViewInteraction mainView = onView(ViewMatchers.withId(R.id.instructions_text_view));

        // Act
        // no action performed for this test, only loading the view

        // Assert
        mainView.check(matches(isDisplayed()));

    }
}
