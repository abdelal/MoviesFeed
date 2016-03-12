package ali.test;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;

import ali.test.Utils.HTTPUtils;
import ali.test.Utils.IOUtils;
import ali.test.appleentities.Movie;


public class Task extends AsyncTask<String, Void, ArrayList<Movie>> {

    @Override
    protected ArrayList<Movie> doInBackground(String... params) {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            //   InputStream in = HTTPUtils.getInputStrem(params[0]);
            InputStream in = HTTPUtils.getInputStrem(params[0]);


            String sjson1 = IOUtils.readStream(in);
            System.out.println(sjson1);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONObject jsono = new JSONObject(sjson1);

            JSONObject feed = jsono.getJSONObject("feed");
            JSONArray movies1 = feed.getJSONArray("entry");


            for (int i = 0; i < movies1.length(); i++) {

                JSONObject child = movies1.getJSONObject(i);


                String childs = child.toString();


                //System.out.println(childs);


                Movie movie = gson.fromJson(childs, Movie.class);

                movies.add(movie);


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return movies;
    }


}
