package com.hackernews.example.controller;


import android.util.Log;


import com.hackernews.example.model.api.RestApiManager;
import com.hackernews.example.model.pojo.TestStories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Vinay on 22/05/16.
 */
public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private TestStoryCallbackListener mListener;
    private RestApiManager mApiManager;

    public Controller(TestStoryCallbackListener listener) {
        mListener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching(ArrayList<Integer> list) {
       /* mApiManager.getTestStoryApi().getTestStoryitem(list,new Callback<ArrayList<Integer>>() {


            @Override
            public void success(ArrayList<Integer> integers, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "Error :: " + error.getMessage());
                mListener.onFetchComplete();
            }
        });*/
    }

    public interface TestStoryCallbackListener {

        void onFetchStart();
        void onFetchProgress(TestStories flower);
        void onFetchProgress(List<TestStories> testStoryList);
        void onFetchComplete();
        void onFetchFailed();
    }
}
