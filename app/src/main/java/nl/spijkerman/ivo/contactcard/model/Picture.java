
package nl.spijkerman.ivo.contactcard.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "large",
    "medium",
    "thumbnail"
})
public class Picture implements Serializable
{

    @JsonProperty("large")
    public String large;
    @JsonProperty("medium")
    public String medium;
    @JsonProperty("thumbnail")
    public String thumbnail;
    private final static long serialVersionUID = 4259077180654176250L;

}
