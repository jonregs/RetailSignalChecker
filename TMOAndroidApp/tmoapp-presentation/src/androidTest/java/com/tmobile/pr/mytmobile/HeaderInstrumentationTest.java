package com.tmobile.pr.mytmobile;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.content.ContextCompat;

import com.tmobile.pr.mytmobile.home.HomeActivity;
import com.tmobile.pr.mytmobile.message.MessageActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.mockito.AdditionalMatchers.not;


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
        ViewInteraction textView = onView(withId(R.id.card_body)).check(matches(isDisplayed()));
        textView.check(matches(withText("Welcome to the T-Mobile app")));


        ViewInteraction textView2 = onView(withId(R.id.card_title)).check(matches(isDisplayed()));
        textView2.check(matches(withText("Hello World")))
                .check(matches(isDisplayed()));
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
        onView(withText(R.string.home_navigate)).
                inRoot(withDecorView(
                        not(is(mActivityRule.getActivity().
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @Test
    public void displayCustomerCareNavigationToast() {
        //openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.customer_navigate)).perform(click());
        intended(hasComponent(MessageActivity.class.getName()));
        onView(withId(R.id.home_icon))
                .check(matches(withTextColor(ContextCompat.getColor(mActivityRule.getActivity(), R.color.black))));
        onView(withId(R.id.message_icon))
                .check(matches(withTextColor(ContextCompat.getColor(mActivityRule.getActivity(), R.color.black))));
        onView(withId(R.id.toolbar_title))
                .perform(replaceText("New Title"))
                .check(matches(withTextColor(ContextCompat.getColor(mActivityRule.getActivity(), R.color.black))));
    }

    @Test
    public void headTextColor() {
        onView(withId(R.id.card_title))
                .check(matches(withText(R.string.hello)))
                .check(matches(withTextColor(ContextCompat.getColor(mActivityRule.getActivity(), R.color.black))));
    }


}

