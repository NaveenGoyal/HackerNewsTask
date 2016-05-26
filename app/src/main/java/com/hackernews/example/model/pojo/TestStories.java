package com.hackernews.example.model.pojo;

/**
 * Created by n.goyal on 5/23/2016.
 */
public class TestStories {

    public long mTestStoryID;
    public String mtitle;
    public String mBy;
    public String mUrl;

    public String mDescendants;
    public int mScore;
    public String mType;


    public TestStories(Builder builder){
        mtitle= builder.mTitle;
        mBy = builder.mBy;
        mScore = builder.mScore;
        mUrl = builder.mURL;
        mTestStoryID = builder.mTestStoryID;
        mType = builder.mType;
        mDescendants = builder.mDescendants;



    }



    public static class Builder {

        private String mTitle, mBy, mURL, mDescendants,mType;
        private long mTestStoryID;
        private int mScore;

        public Builder setTitle(String title) {
            mTitle = title;
            return Builder.this;
        }

        public Builder setType(String type) {
            mType = type;
            return Builder.this;
        }

        public Builder setURL(String url) {
            mURL = url;
            return Builder.this;
        }

        public Builder setBy(String by) {
            mBy = by;
            return Builder.this;
        }

        public Builder setTestStoryID(long testStoryID) {
            mTestStoryID = testStoryID;
            return Builder.this;
        }

        public Builder setScore(int score) {
            mScore = score;
            return Builder.this;
        }

        public TestStories build() {
            return new TestStories(Builder.this);
        }
    }

}
