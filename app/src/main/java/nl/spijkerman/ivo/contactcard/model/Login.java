
package nl.spijkerman.ivo.contactcard.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uuid",
    "username",
    "password",
    "salt",
    "md5",
    "sha1",
    "sha256"
})
public class Login implements Serializable
{

    @JsonProperty("uuid")
    public String uuid;
    @JsonProperty("username")
    public String username;
    @JsonProperty("password")
    public String password;
    @JsonProperty("salt")
    public String salt;
    @JsonProperty("md5")
    public String md5;
    @JsonProperty("sha1")
    public String sha1;
    @JsonProperty("sha256")
    public String sha256;
    private final static long serialVersionUID = -3443376149939263440L;

}
