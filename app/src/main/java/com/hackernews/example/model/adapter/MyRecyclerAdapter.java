package com.hackernews.example.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hackernews.example.model.api.TestStoryAPI;
import com.hackernews.example.model.pojo.TestStories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import hackernews.example.com.hackernewstask.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by n.goyal on 5/23/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
    private ArrayList<Integer> testItemList;

    public static final String TEST_STORY_ITEM_URL="https://hacker-news.firebaseio.com/v0/item/";


    public MyRecyclerAdapter(ArrayList<Integer> testItemList) {
        this.testItemList = testItemList;

    }


    /*public void addTestStory(TestStories testStory){
        this.testItemList.add(testStory);
    }*/

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_list, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {

         long testItem = testItemList.get(i);



        Log.d("Naveen","Items in the List is"+ testItem);


        RestAdapter itemAdapetr = new RestAdapter.Builder()
                .setEndpoint(TEST_STORY_ITEM_URL)
                .build();
        TestStoryAPI api_item = itemAdapetr.create(TestStoryAPI.class);

        api_item.getTestStoryitem(testItem, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d("Naveen", "Success" +s);

                try {


                    JSONArray array = new JSONArray(s);

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        //Setting text view title
                        customViewHolder.textView1.setText(object.getString("title"));
                        customViewHolder.textView2.setText(object.getString("by"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.d("Naveen","Failure" +retrofitError);

            }
        });


    }

    @Override
    public int getItemCount() {



        return (null != testItemList ? testItemList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        //Log.d("Naveen","Create the onCreatViewHolder");

        protected TextView textView1,textView2;

        public CustomViewHolder(View view) {
            super(view);

            this.textView1 = (TextView) view.findViewById(R.id.title_topStories);
            this.textView2 = (TextView) view.findViewById(R.id.by);
        }
    }
}
