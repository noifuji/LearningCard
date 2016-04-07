package jp.noifuji.learningcard;

import java.util.Date;

/**
 * Created by ryoma on 2016/03/31.
 */
public class Card {
    private int mId;
    private String mQuestion;
    private String mAnswer;
    private String mRating;
    private Date mTimeStamp;

    public Card(int id, String question, String answer) {
        mId = id;
        mQuestion = question;
        mAnswer = answer;
        mRating = "Blank";
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public Date getTimeStamp() {
        return mTimeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        mTimeStamp = timeStamp;
    }

}
