package com.hackernews.example.model.api;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by n.goyal on 5/23/2016.
 */
public interface TestStoryAPI {

    @GET("/topstories.json")
    void getTestStory(Callback<ArrayList<Integer>> response);


    @GET("/item/{id}.json")
    void getTestStoryitem(@Path("id")long id, Callback<String> response);


}
