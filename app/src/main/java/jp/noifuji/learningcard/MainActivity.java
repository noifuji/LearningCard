package jp.noifuji.learningcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.noifuji.learningcard.data.CardDataRepository;
import jp.noifuji.learningcard.logic.LogicExecutor;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CardRepository mCardRepository;
    private LogicExecutor mLogicExecutor;
    private MainPresenter mPresenter;

    @Bind(R.id.text_count_excellent)
    TextView mExcellentTextCount;
    @Bind(R.id.text_count_good)
    TextView mGoodTextCount;
    @Bind(R.id.text_count_bad)
    TextView mBadTextCount;
    @Bind(R.id.text_count_blank)
    TextView mBlankTextCount;

    @OnClick(R.id.layout_excellent)
    public void onExcellentClicked() {
        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra("rating", "Excellent");
        startActivity(intent);
    }

    @OnClick(R.id.layout_good)
    public void onGoodClicked() {
        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra("rating", "Good");
        startActivity(intent);
    }

    @OnClick(R.id.layout_bad)
    public void onBadClicked() {
        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra("rating", "Bad");
        startActivity(intent);
    }

    @OnClick(R.id.layout_blank)
    public void onBlankClicked() {
        Intent intent = new Intent(this, CardListActivity.class);
        intent.putExtra("rating", "Blank");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        mCardRepository = CardDataRepository.getInstance();
        mLogicExecutor = ((ApplicationComponent)getApplication()).getLogicExecutor();

        mPresenter = new MainPresenter(this, mLogicExecutor, mCardRepository);
        mPresenter.create();


    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        ButterKnife.unbind(this);
    }

    public void startLoading() {
        mBadTextCount.setText("loading");
        mExcellentTextCount.setText("loading");
        mBlankTextCount.setText("loading");
        mGoodTextCount.setText("loading");
    }

    public void stopLoading() {
        List<Card> e = mCardRepository.getCardsByRating("Excellent");
        mExcellentTextCount.setText(e.size() + "枚");
        List<Card> g = mCardRepository.getCardsByRating("Good");
        mGoodTextCount.setText(g.size() + "枚");
        List<Card> b = mCardRepository.getCardsByRating("Bad");
        mBadTextCount.setText(b.size() + "枚");
        List<Card> bl = mCardRepository.getCardsByRating("Blank");
        mBlankTextCount.setText(bl.size() + "枚");
    }


}
