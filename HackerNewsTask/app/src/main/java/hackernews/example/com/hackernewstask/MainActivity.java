package hackernews.example.com.hackernewstask;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TEST_STORY_URL= "https://hacker-news.firebaseio.com/v0";

    public static final String Test_Story_ID="id";




    private RecyclerView recyclerView;

    private ArrayList<Integer> testStorieslist;


    private MyRecyclerAdapter adapter1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        getTestStories();

    }


    private void getTestStories(){

        Log.d("Naveen","Getting the test Stories");

        final RestAdapter adapter = new RestAdapter.Builder()
                             .setEndpoint(TEST_STORY_URL)
                             .build();


        TestStoryAPI api = adapter.create(TestStoryAPI.class);

        api.getTestStory(new Callback<ArrayList<Integer>>() {
            @Override
            public void success(ArrayList arrayList, Response response) {
                Log.d("Naveen","Got the Response"+arrayList.size());

                testStorieslist = arrayList;

                Log.d("Naveen","Items in ArrayList"+testStorieslist.get(0));


                displayList();
            }

            @Override
            public void failure(RetrofitError retrofitError) {

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


}
