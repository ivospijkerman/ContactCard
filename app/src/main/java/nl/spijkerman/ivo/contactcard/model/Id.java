
package nl.spijkerman.ivo.contactcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "value"
})
public class Id implements Serializable {

    @JsonProperty("name")
    public String name;
    @JsonProperty("value")
    public Object value;
    private final static long serialVersionUID = 4381142848805937647L;

}
