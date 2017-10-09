package com.tmobile.pr.mytmobile;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.tmobile.pr.mytmobile.home.HomeActivity;
import com.tmobile.pr.mytmobile.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by asaifudeen on 10/2/17.
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        Intents.init();
    }

    @After
    public void teardown() {
        Intents.release();
    }

    @Test
    public void clickOnLogin() {
        onView(withId(R.id.loginIV)).check(matches(isDisplayed()));
        onView(withId(R.id.loginIV)).perform(ViewActions.click());
        intended(hasComponent(HomeActivity.class.getName()));


    }

}
