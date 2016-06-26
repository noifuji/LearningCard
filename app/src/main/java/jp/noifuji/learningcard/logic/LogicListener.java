package jp.noifuji.learningcard.logic;

/**
 * Created by ryoma on 2016/06/26.
 */
public interface LogicListener <D> {
    void onComplete(D result);
    void onError(String error);
}
