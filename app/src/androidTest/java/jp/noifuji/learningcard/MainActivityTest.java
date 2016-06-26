package jp.noifuji.learningcard;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.squareup.spoon.Spoon;

/**
 * Created by ryoma on 2016/06/25.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Instrumentation instrumentation;
    private MainActivity activity;


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override protected void setUp() throws Exception {
        super.setUp();
        instrumentation = getInstrumentation();
        activity = getActivity();
    }

    public void testEmptyForm_ShowsBothErrors() {
        Spoon.screenshot(activity, "initial_state");

        // Make sure the initial state does not show any errors.
       // assertThat(username).hasNoError();
       // assertThat(password).hasNoError();

        // Click the "login" button.
    //    instrumentation.runOnMainSync(new Runnable() {
       //     @Override public void run() {
     //           login.performClick();
     //       }
     //   });
     //   instrumentation.waitForIdleSync();

      //  Spoon.screenshot(activity, "login_clicked");

        // Verify errors were shown for both input fields.
      //  assertThat(username).hasError(R.string.required);
      //  assertThat(password).hasError(R.string.required);
    }
}
