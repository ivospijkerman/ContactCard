
package nl.spijkerman.ivo.contactcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results",
        "info"
})
public class Result implements Serializable {

    @JsonProperty("results")
    public List<Contact> results = null;
    @JsonProperty("info")
    public Info info;
    private final static long serialVersionUID = 7970914799052012255L;

}
