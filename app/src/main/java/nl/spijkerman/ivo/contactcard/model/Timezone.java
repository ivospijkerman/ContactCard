
package nl.spijkerman.ivo.contactcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "offset",
        "description"
})
public class Timezone implements Serializable {

    @JsonProperty("offset")
    public String offset;
    @JsonProperty("description")
    public String description;
    private final static long serialVersionUID = 3148055441644953589L;

}
