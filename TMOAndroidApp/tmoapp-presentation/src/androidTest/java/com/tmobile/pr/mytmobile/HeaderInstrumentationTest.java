package com.tmobile.pr.mytmobile;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.tmobile.pr.mytmobile.home.HomeActivity;
import com.tmobile.pr.mytmobile.message.MessageActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class HeaderInstrumentationTest extends BaseTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityRule = new ActivityTestRule<>(
        HomeActivity.class);

    @Test
    public void toolbarTest() {
        ViewInteraction toolbar = onView(withId(R.id.global_header));
        toolbar.check(matches(isDisplayed()));
    }

    @Test
    public void helloCardTest() {
        onView(allOf(withIndex(allOf(withId(R.id.card_title)), 1), isDisplayed()))
            .check(matches(withText(R.string.hello)));

        onView(allOf(withIndex(allOf(withId(R.id.card_body)), 1), isDisplayed()))
            .check(matches(withText(R.string.welcome_text)));
    }

    @Test
    public void toolbarHomeIconTest() {
        onView(withId(R.id.home_icon))
            .check(matches(isDisplayed()));
    }

    @Test
    public void toolbarMessageIconTest() {
        onView(withId(R.id.message_icon))
            .check(matches(isDisplayed()));
    }

    @Test
    public void toolbarTitleTest() {
        onView(withId(R.id.toolbar_title))
            //.check(matches(withParent(withId(R.id.global_header))))
            .check(matches(withText("")));

    }

    @Test
    public void displayHomeNavigationToast() {
        onView(withId(R.id.home_icon)).perform(click());
        //intended(hasComponent(HomeFragment.class.getName()));
    }

    @Test
    public void messageIconClickTest() {
        onView(withId(R.id.message_icon)).perform(click());
        intended(hasComponent(MessageActivity.class.getName()));
    }

}

