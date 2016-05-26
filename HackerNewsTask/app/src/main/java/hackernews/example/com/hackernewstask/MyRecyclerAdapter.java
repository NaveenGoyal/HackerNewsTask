package hackernews.example.com.hackernewstask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by n.goyal on 5/23/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
    private ArrayList<Integer> testItemList;


    public MyRecyclerAdapter(ArrayList<Integer> testItemList) {
        this.testItemList = testItemList;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        Log.d("Naveen","Inside the onCreatViewHolder");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_list, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Log.d("Naveen","Inside the onBindViewHolder");
        Integer testItem = testItemList.get(i);


        Log.d("Naveen","Item to be Dsiplayed"+ testItem);

        //Setting text view title
        customViewHolder.textView.setText(testItem.toString());
    }

    @Override
    public int getItemCount() {

        return (null != testItemList ? testItemList.size() : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        //Log.d("Naveen","Create the onCreatViewHolder");

        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);

            this.textView = (TextView) view.findViewById(R.id.title);
        }
    }
}
