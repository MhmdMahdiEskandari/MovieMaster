package moviemaster.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    @JsonProperty("Source")
    private String Source;
    @JsonProperty("Value")
    private String Value;
}