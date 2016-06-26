package jp.noifuji.learningcard;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

/**
 * Created by ryoma on 2016/03/30.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    private List<Card> mDataSet;
    private DataSetListener mDataSetListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        CardView cv;
        TextView mQuestionText;
        TextView mAnswerText;
        LinearLayout mButtonsLayout;
        Button goodButton;
        Button badButton;
        Button excellentButton;

        public ViewHolder(View v) {
            super(v);
            mButtonsLayout = (LinearLayout) itemView.findViewById(R.id.layout_answer);
            cv = (CardView) itemView.findViewById(R.id.cv);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mButtonsLayout.setVisibility(View.VISIBLE);
                }
            });
            mQuestionText = (TextView) itemView.findViewById(R.id.text_question);
            mAnswerText = (TextView) itemView.findViewById(R.id.text_answer);
            goodButton = (Button) itemView.findViewById(R.id.button_good);
            badButton = (Button) itemView.findViewById(R.id.button_bad);
            excellentButton = (Button) itemView.findViewById(R.id.button_excellent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CardListAdapter(List<Card> myDataSet) {
        mDataSet = myDataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Card data;
        holder.mButtonsLayout.setVisibility(View.GONE);
        data = mDataSet.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mQuestionText.setText(data.getQuestion());
        holder.mAnswerText.setText(data.getAnswer());
        holder.goodButton.setOnClickListener(new View.OnClickListener() {
            int i;

            public View.OnClickListener setArg(int i) {
                this.i = i;
                return this;
            }

            @Override
            public void onClick(View v) {
                for (int i = 0; i < mDataSet.size(); i++) {
                    Card card = mDataSet.get(i);
                    if (card.equals(data)) {
                        card.setRating("Good");
                        card.setTimeStamp(new Date());
                        mDataSetListener.onDataRemoved(card);
                        mDataSet.remove(i);
                        notifyItemRemoved(i);
                        break;
                    }
                }
            }
        }.setArg(position));

        holder.badButton.setOnClickListener(new View.OnClickListener() {
            int i;

            public View.OnClickListener setArg(int i) {
                this.i = i;
                return this;
            }

            @Override
            public void onClick(View v) {
                for (int i = 0; i < mDataSet.size(); i++) {
                    Card card = mDataSet.get(i);
                    if (card.equals(data)) {
                        card.setRating("Bad");
                        card.setTimeStamp(new Date());
                        mDataSetListener.onDataRemoved(card);
                        mDataSet.remove(i);
                        notifyItemRemoved(i);
                        break;
                    }
                }
            }
        }.setArg(position));

        holder.excellentButton.setOnClickListener(new View.OnClickListener() {
            int i;

            public View.OnClickListener setArg(int i) {
                this.i = i;
                return this;
            }

            @Override
            public void onClick(View v) {
                for (int i = 0; i < mDataSet.size(); i++) {
                    Card card = mDataSet.get(i);
                    if (card.equals(data)) {
                        card.setRating("Excellent");
                        card.setTimeStamp(new Date());
                        mDataSetListener.onDataRemoved(card);
                        mDataSet.remove(i);
                        notifyItemRemoved(i);
                        break;
                    }
                }
            }
        }.setArg(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public interface DataSetListener {
        void onDataRemoved(Card card);
    }

    public void registerDataSetListener(DataSetListener listener) {
        this.mDataSetListener = listener;
    }

    public void unregisterDataSetListener() {
        this.mDataSetListener = null;
    }
}
