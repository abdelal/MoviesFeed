package ali.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import ali.test.appleentities.Movie;

public class Main2Activity extends AppCompatActivity {


    RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rc=(RecyclerView) findViewById(R.id.rcview);

        try {
            ArrayList<Movie> reddits= new Task().execute("https://itunes.apple.com/il/rss/topmovies/limit=25/genre=4401/json").get();
            Radapter radapter=new Radapter(reddits,this);
            rc.setLayoutManager(new LinearLayoutManager(this));
            rc.setAdapter(radapter);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }





    }

}
