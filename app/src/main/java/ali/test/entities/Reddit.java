
package ali.test.entities;

import java.util.ArrayList;
import java.util.List;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Reddit {


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("title")
    @Expose
    private String title;




    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Reddit{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getThumbnail() {
        return thumbnail;
    }


    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


}
