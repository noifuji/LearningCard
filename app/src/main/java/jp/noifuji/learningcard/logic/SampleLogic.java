package jp.noifuji.learningcard.logic;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.List;

import jp.noifuji.learningcard.Card;
import jp.noifuji.learningcard.CardRepository;

/**
 * Created by ryoma on 2016/06/26.
 */
public class SampleLogic implements Logic {
    private static final String TAG = "SampleLogic";
    private SampleLogicListener mListener;
    private Handler mListenerHandler;
    private CardRepository mCardRepository;

    public interface SampleLogicListener {
        void onComplete(String result);
        void onError(String error);
    }

    public SampleLogic(SampleLogicListener listener, Looper looper, CardRepository repository) {
        this.mListener = listener;
        this.mListenerHandler = new Handler(looper);
        this.mCardRepository = repository;
    }

    @Override
    public void run() {
        Log.d(TAG, "run() : " + Thread.currentThread().toString());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Card> e = mCardRepository.getCardsByRating("Excellent");
        List<Card> g = mCardRepository.getCardsByRating("Good");
        List<Card> b = mCardRepository.getCardsByRating("Bad");
        List<Card> bl = mCardRepository.getCardsByRating("Blank");


        mListenerHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onComplete("result");
            }
        });
    }
}
