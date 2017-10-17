package com.tmobile.pr.mytmobile;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import com.tmobile.pr.mytmobile.home.view.HomeActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by Santhosh on 10/6/2017.
 */

public class FooterTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule =
        new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setUp() throws Exception {
        Intents.init();
    }

    @After
    public void teardown() {
        Intents.release();
    }

    @Test
    public void footerDisplayTest() {
        onView(withId(R.id.home_footer)).check(matches(isDisplayed()));
    }

    @Test
    public void footerClickTest() {
        onView((withText(R.string.my_account))).perform(click());
        onView(withText(R.string.my_account)).inRoot(withDecorView(
            not(is(mActivityTestRule.getActivity().
                getWindow().getDecorView())))).
            check(matches(isDisplayed()));
    }
}
