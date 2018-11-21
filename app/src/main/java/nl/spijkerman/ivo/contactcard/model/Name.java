
package nl.spijkerman.ivo.contactcard.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "first",
    "last"
})
public class Name implements Serializable
{

    @JsonProperty("title")
    public String title;
    @JsonProperty("first")
    public String first;
    @JsonProperty("last")
    public String last;
    private final static long serialVersionUID = 8519608992595671471L;

}
