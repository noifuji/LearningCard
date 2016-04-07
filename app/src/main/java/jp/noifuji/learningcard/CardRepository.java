package jp.noifuji.learningcard;

import java.util.List;

/**
 * Created by ryoma on 2016/03/31.
 */
public interface CardRepository {
    Card getCardById(int id);
    List<Card> getCardsByRating(String rating);
    void updateCards(List<Card> cards);
    void insertCards(List<Card> cards);
}
