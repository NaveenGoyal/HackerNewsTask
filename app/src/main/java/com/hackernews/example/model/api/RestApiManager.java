package com.hackernews.example.model.api;


import com.google.gson.GsonBuilder;
import com.hackernews.example.model.utilities.Constants;


import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by n.goyal on 22/05/16.
 */
public class RestApiManager {
    private TestStoryAPI mtestStoryApi;

    public TestStoryAPI getTestStoryApi() {

        if(mtestStoryApi == null) {
            GsonBuilder gson = new GsonBuilder();
            gson.registerTypeAdapter(String.class, new StringDesirializer());

            mtestStoryApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gson.create()))
                    .build()
                    .create(TestStoryAPI.class);
        }
        return mtestStoryApi;
    }

}
