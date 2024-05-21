package alvarez.wilfredo.reactivecouchdb.service.user.datasource.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("_rev")
    private String revision;
}
