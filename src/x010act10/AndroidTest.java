package x010act10;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import org.hamcrest.Matcher;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static jtm.android.MainActivity.getColor;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Instrumented test, which will execute on an (virtual) Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class) // Android GUI Test
@LargeTest // Emulation mode
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Run test methods in alphabetical order
public class AndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    private int r, g, b; // RGB parts of color

    /**
     * @param color — expected color of mainScreen background
     * @return —  ViewAssertion object for ViewInteraction check() method
     */
    private static ViewAssertion checkBackground(final int color) {
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                Log.i("checkBacground", "color:" + color + " view:" + view.toString());
                ColorDrawable colorDrawable = (ColorDrawable) view.getBackground();
                if (colorDrawable == null)
                    fail("Background color is not set");
                else
                    assertEquals("Wrong background color", color, colorDrawable.getColor());
            }
        };

    }

    /**
     * @param progress — value of the used SeekBar
     * @return — ViewAction object for ViewInteraction perform() method
     */
    private static ViewAction setSeekBar(final int progress) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                SeekBar seekBar = ((SeekBar) view);
                seekBar.setProgress(progress);
                assertEquals("SeekBar color setting error", seekBar.getProgress(), progress);
                Log.i("setSeekBar", "progress:" + progress + " seekBar:" + seekBar.toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public String getDescription() {
                return "Set a seek bar progress";
            }

            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(SeekBar.class);
            }
        };
    }

    /**
     * Check that initial background color is black
     */
    @Test
    public void test1InitialColor() {
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));
    }

    /**
     * Check that background color changes accordingly to seek bar values
     */
    @Test
    public void test2SeekBars() {
        r = 255;
        onView(withId(R.id.seekBarR))
                .perform(setSeekBar(r));
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));
        g = 255;
        onView(withId(R.id.seekBarG))
                .perform(setSeekBar(g));
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));
        b = 255;
        onView(withId(R.id.seekBarB))
                .perform(setSeekBar(b));
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));
        r = 0;
        onView(withId(R.id.seekBarR))
                .perform(setSeekBar(r));
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));
        g = 0;
        onView(withId(R.id.seekBarG))
                .perform(setSeekBar(g));
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));
        b = 0;
        onView(withId(R.id.seekBarB))
                .perform(setSeekBar(b));
        onView(withId(R.id.mainScreen)).
                check(checkBackground(getColor(r, g, b)));

    }

}