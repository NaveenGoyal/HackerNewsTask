package hackernews.example.com.hackernewstask;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by n.goyal on 5/23/2016.
 */
public interface TestStoryAPI {

    @GET("/topstories.json")
    void getTestStory(Callback<ArrayList<Integer>> response);
}
