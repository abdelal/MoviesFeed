
package ali.test.appleentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes_ {

    @SerializedName("im:id")
    @Expose
    private String imId;

    /**
     * 
     * @return
     *     The imId
     */
    public String getImId() {
        return imId;
    }

    /**
     * 
     * @param imId
     *     The im:id
     */
    public void setImId(String imId) {
        this.imId = imId;
    }

}
