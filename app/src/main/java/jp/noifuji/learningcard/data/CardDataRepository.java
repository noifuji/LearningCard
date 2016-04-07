package jp.noifuji.learningcard.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jp.noifuji.learningcard.Card;
import jp.noifuji.learningcard.CardRepository;

/**
 * Created by ryoma on 2016/03/31.
 */
public class CardDataRepository implements CardRepository {

    private static final String TAG = "CardDataRepository";

    //test
    ArrayList<Card> list;
    static CardDataRepository instance;

    public static CardDataRepository getInstance() {
        if(instance == null) {
            instance =  new CardDataRepository();
        }
        return instance;
    }

    public CardDataRepository() {
        list = new ArrayList<>();
        list.add(new Card(1, "私は朝6時前に起きることに慣れている。"
                , "I'm used to getting up before 6 in the morning."));
        list.add(new Card(2, "新しい環境に慣れるのに3ヶ月かかった。"
                , "It took me 3 months to get used to the new environment."));
        list.add(new Card(3, "人を降格させるのは簡単ではない。"
                , "It's not easy to demote people."));
    }

    @Override
    public Card getCardById(int id) {
        return null;
    }

    @Override
    public List<Card> getCardsByRating(String rating) {
        List<Card> result = new ArrayList();

        for(Card card: list) {
            Log.d(TAG, "rating : " + rating);
            if(card.getRating().equals(rating)) {
                result.add(card);
                Log.d(TAG, "rating : " + rating);
            }
        }
        return result;
    }

    @Override
    public void updateCards(List<Card> cards) {
        for(Card card : cards) {
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).getId() == card.getId()) {
                    list.set(i, card);
                    for(Card c: list) {
                        Log.d(TAG, "rate : " + c.getRating());
                    }
                }
            }
        }
    }

    @Override
    public void insertCards(List<Card> cards) {

    }
}
