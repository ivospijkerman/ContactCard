
package nl.spijkerman.ivo.contactcard.model;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.text.WordUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "first",
        "last"
})
public class Name implements Serializable {

    @JsonProperty("title")
    public String title;
    @JsonProperty("first")
    public String first;
    @JsonProperty("last")
    public String last;
    private final static long serialVersionUID = 8519608992595671471L;


    @Override
    public String toString() {
        return Stream.of(first, last).map(WordUtils::capitalize).collect(Collectors.joining(" "));
    }
}
