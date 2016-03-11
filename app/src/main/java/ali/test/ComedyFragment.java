package ali.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import ali.test.appleentities.Movie;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComedyFragment extends Fragment {


    RecyclerView rc;

    public ComedyFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_actionfragment, container, false);
        try {
            rc=(RecyclerView) v.findViewById(R.id.rcview2);
            ArrayList<Movie> movies= new Task().execute("https://itunes.apple.com/il/rss/topmovies/limit=25/genre=4404/json").get();
            Radapter radapter=new Radapter(movies,getContext());
            rc.setLayoutManager(new LinearLayoutManager(v.getContext()));
            rc.setAdapter(radapter);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return v;

    }

}
