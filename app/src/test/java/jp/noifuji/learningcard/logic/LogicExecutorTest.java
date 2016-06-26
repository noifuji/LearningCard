package jp.noifuji.learningcard.logic;

import android.util.Log;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by ryoma on 2016/06/26.
 */
public class LogicExecutorTest {
    @Test
    public void sample() throws Exception {
        LogicExecutor le = new LogicExecutor();
        le.request(new Logic() {
            @Override
            public void handle() {
                Log.d("Test", "Worker Thread is working.");
                assertTrue(false);
            }
        });
    }
}