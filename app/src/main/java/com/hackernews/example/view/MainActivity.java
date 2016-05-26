package com.hackernews.example.view;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;


import com.hackernews.example.controller.Controller;
import com.hackernews.example.model.adapter.MyRecyclerAdapter;
import com.hackernews.example.model.api.TestStoryAPI;
import com.hackernews.example.model.pojo.TestStories;


import java.util.ArrayList;
import java.util.List;


import hackernews.example.com.hackernewstask.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity  implements  Controller.TestStoryCallbackListener{

    public static final String TEST_STORY_URL= "https://hacker-news.firebaseio.com/v0";




    public static final String TEST_STORY_ITEM_URL="https://hacker-news.firebaseio.com/v0/item/";


    private RecyclerView recyclerView;

    private ArrayList<Integer> testStorieslist;


    private MyRecyclerAdapter adapter1;

    private Controller mController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController = new Controller(MainActivity.this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        getTestStories();

    }


    private void getTestStories(){

        Log.d("Naveen", "Getting the test Stories");

        final RestAdapter adapter = new RestAdapter.Builder()
                             .setEndpoint(TEST_STORY_URL)
                             .build();


        TestStoryAPI api = adapter.create(TestStoryAPI.class);

        api.getTestStory(new Callback<ArrayList<Integer>>() {
            @Override
            public void success(ArrayList arrayList, Response response) {


                testStorieslist = arrayList;

                //mController.startFetching(testStorieslist);

                //getTopStoriesData();
                displayList();
            }

            @Override
            public void failure(RetrofitError retrofitError) {


            }
        });

    }


    private void getTopStoriesData(){


        long id = 192327;

        Log.d("Naveen", "Getting the test Stories item");


        Log.d("Naveen", "URL is "+ TEST_STORY_ITEM_URL + testStorieslist.get(1).toString());
        RestAdapter itemAdapetr = new RestAdapter.Builder()
                                 .setEndpoint(TEST_STORY_ITEM_URL)
                                  .build();
        TestStoryAPI api_item = itemAdapetr.create(TestStoryAPI.class);

        api_item.getTestStoryitem(id, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d("Naveen","Success");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("Naveen","Failure" +retrofitError);

            }
        });

    }

    private void displayList(){

        /*int[] test_stories = new int[testStorieslist.size()];

        for(int i=0;i<testStorieslist.size();i++){
            test_stories[i] = testStorieslist.get(i).getTeststory_ID();
        }*/


        Log.d("Naveen","Display The List"+testStorieslist.size());
        adapter1 = new MyRecyclerAdapter(testStorieslist);

        recyclerView.setAdapter(adapter1);

    }


    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(TestStories testStories) {
        //adapter1.addTestStory(testStories);

    }

    @Override
    public void onFetchProgress(List<TestStories> flowerList) {

    }

    @Override
    public void onFetchComplete() {

    }

    @Override
    public void onFetchFailed() {

    }
}
