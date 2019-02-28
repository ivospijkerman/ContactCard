
package nl.spijkerman.ivo.contactcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "seed",
        "results",
        "page",
        "version"
})
public class Info implements Serializable {

    @JsonProperty("seed")
    public String seed;
    @JsonProperty("results")
    public Integer results;
    @JsonProperty("page")
    public Integer page;
    @JsonProperty("version")
    public String version;
    private final static long serialVersionUID = -5407066763201994388L;

}
