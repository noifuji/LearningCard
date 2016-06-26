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
        list.add(new Card(1,"その上司は、研修生たちが部外秘のファイルにアクセスすることを許さなかった。","The boss did not permit the trainees to have access to confidential files."));
        list.add(new Card(2,"彼女はキャリアを変えることを考えていたが、結局しないことに決めた。","She considered changing careers, but in the end she decided not to."));
        list.add(new Card(3,"そのCFOはアメリカにいた時に、新しいマーケティングの計画を練ることを楽しんだ。","The CFO enjoyed cooking up new marketing schemes when she was in the U.S."));
        list.add(new Card(4,"我々は最終的に、彼らをなんとか説得して香港でジョントベンチャーを設立させた。","We finally managed to persuade them into setting up a joint venture in Hong Kong."));
        list.add(new Card(5,"私たちは、議会がこの問題に関する議論を中止するよう提案するつもりです。","We intend to move that the committee suspend discussion on this issue."));
        list.add(new Card(6,"彼のテストの点数から判断すると、その生徒は別の大学に通うべきだ。","Judging from his marks on the test, the student should attend a different university."));
        list.add(new Card(7,"そのCEOは父親産休に関する指示がただちに運用されることを期待している。","The chief executive expects his directive on paternity leave to be carried out right away."));
        list.add(new Card(8,"そのプラントのマネージャーが病気になったので、彼は重機を操作することを避けた。","The plant manager felt sick, so he avoided operating heavy machinery;"));
        list.add(new Card(9,"人々が30歳前にリタイアするという考えはもはや夢ではない。","The concept of people retiring before thirty is no longer a dream."));
        list.add(new Card(10,"そのCEOは先週に同じ草案を読んだことを思い出したと言った。","The CEO said that he remembered reading the same draft proposal last week."));
        list.add(new Card(11,"コピーライティングのセミナーに約300人の客が出席していた。","There were about 300 guests attending the seminar on copy writing."));
        list.add(new Card(12,"そのチームのプロジェクトの多くは完成に程遠かった。","None of the team's many projects were anywhere near completion."));
        list.add(new Card(13,"素晴らしそうなプロジェクトは彼女空き時間をどんどん占めつつある。","What seemed like a wonderful project was occupying more and more of her spare time."));
        list.add(new Card(14,"ロバーツさんは魅力的な提案を受けたので、新しい役職に就くため、現在の役職をやめる。","Mr.Roberts get on attractive offer, so he quit his current position to take the new one."));
        list.add(new Card(15,"彼女のビジネス拡大計画は変更の余地がない。","Her business expansion plan leaves no room for change."));
        list.add(new Card(16,"インターネットの使い方を学ばないことで、代償を払うことになるでしょう。","One will pay a price for not learning how to utilize the Internet."));
        list.add(new Card(17,"その上司は合併交渉がスムーズに進行しているかを尋ねた。","The boss inquired as to whether the merger talks were making smooth progress."));
        list.add(new Card(18,"ほとんどの人々が、本当に新しい憲法を望んでいると言った。","Most of the people said that they really would like a new constitution."));
        list.add(new Card(19,"ガースナーさんは夫を手伝うことができた。","Ms.Gerstner was able to give her husband a hand."));
        list.add(new Card(20,"四半期の予算は数十億ドルから成る。","The quarterly budget consists of billions of dollars."));

    }

    @Override
    public Card getCardById(int id) {
        return null;
    }

    @Override
    public List<Card> getCardsByRating(String rating) {
        List<Card> result = new ArrayList();

        for(Card card: list) {
            //Log.d(TAG, "rating : " + rating);
            if(card.getRating().equals(rating)) {
                result.add(card);
                //Log.d(TAG, "rating : " + rating);
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
