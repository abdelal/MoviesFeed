
package ali.test.appleentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImReleaseDate {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes___ attributes;

    /**
     * 
     * @return
     *     The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    public Attributes___ getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(Attributes___ attributes) {
        this.attributes = attributes;
    }

}
