
package nl.spijkerman.ivo.contactcard.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "street",
    "city",
    "state",
    "postcode",
    "coordinates",
    "timezone"
})
public class Location implements Serializable
{

    @JsonProperty("street")
    public String street;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("postcode")
    public Integer postcode;
    @JsonProperty("coordinates")
    public Coordinates coordinates;
    @JsonProperty("timezone")
    public Timezone timezone;
    private final static long serialVersionUID = 4360531517753459356L;

}
