package jp.noifuji.learningcard;

import android.os.Looper;
import android.util.Log;

import jp.noifuji.learningcard.logic.Logic;
import jp.noifuji.learningcard.logic.LogicExecutor;
import jp.noifuji.learningcard.logic.SampleLogic;

/**
 * Created by ryoma on 2016/06/26.
 */
public class MainPresenter {
    private static final String TAG = "MainPresenter";
    private MainActivity mMainActivity;
    private LogicExecutor mLogicExecutor;
    private CardRepository mCardRepository;

    public MainPresenter(MainActivity activity, LogicExecutor executor, CardRepository repository) {
        mMainActivity = activity;
        mLogicExecutor = executor;
        mCardRepository = repository;
    }

    public void create() {
        Logic logic = new SampleLogic(new SampleLogicListener(), Looper.myLooper(), mCardRepository);
        mLogicExecutor.execute(logic);
        startLoading();
    }

    public void resume() {

    }

    public void destroy() {
        mMainActivity = null;
    }

    private void startLoading() {
        Log.d(TAG, "startLoading");
        if(mMainActivity == null) {
            Log.w(TAG, "The view is already destroyed.");
            return;
        }
        mMainActivity.startLoading();
    }

    private void stopLoading() {
        Log.d(TAG, "stopLoading");
        if(mMainActivity == null) {
            Log.w(TAG, "The view is already destroyed.");
            return;
        }
        mMainActivity.stopLoading();
    }

    class SampleLogicListener implements SampleLogic.SampleLogicListener {

        @Override
        public void onComplete(String result) {
            Log.d(TAG, result);
            stopLoading();
        }

        @Override
        public void onError(String error) {

        }
    }
}
