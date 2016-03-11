
package ali.test.appleentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("movie")
    @Expose
    private Movie movie;

    /**
     * 
     * @return
     *     The movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * 
     * @param movie
     *     The movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
