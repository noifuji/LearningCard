package jp.noifuji.learningcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import jp.noifuji.learningcard.data.CardDataRepository;

public class CardListActivity extends AppCompatActivity implements CardListAdapter.DataSetListener{

    private static final String TAG = "CardListActivity";
    private RecyclerView mRecyclerView;
    private CardListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private CardRepository mCardRepository;

    private String mRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        Intent intent = getIntent();
        mRating = intent.getStringExtra("rating");

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mCardRepository = CardDataRepository.getInstance();
        mAdapter = new CardListAdapter(mCardRepository.getCardsByRating(mRating));
        mAdapter.registerDataSetListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unregisterDataSetListener();
    }

    @Override
    public void onDataRemoved(Card card) {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card);
        mCardRepository.updateCards(cards);
        Log.d(TAG, "Card question : " + card.getQuestion() + " , " + card.getRating());
    }
}
