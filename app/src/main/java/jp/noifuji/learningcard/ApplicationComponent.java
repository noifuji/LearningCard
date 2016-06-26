package jp.noifuji.learningcard;

import android.app.Application;

import jp.noifuji.learningcard.logic.LogicExecutor;

/**
 * Created by ryoma on 2016/06/26.
 */
public class ApplicationComponent extends Application {
    private LogicExecutor mLogicExecutor;

    @Override
    public void onCreate() {
        super.onCreate();
        mLogicExecutor = new LogicExecutor();
    }

    public LogicExecutor getLogicExecutor() {
        return mLogicExecutor;
    }
}
