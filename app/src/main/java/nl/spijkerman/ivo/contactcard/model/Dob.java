
package nl.spijkerman.ivo.contactcard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "age"
})
public class Dob implements Serializable {

    @JsonProperty("date")
    public String date;
    @JsonProperty("age")
    public Integer age;
    private final static long serialVersionUID = -7834740536868268351L;

}
