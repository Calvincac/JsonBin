package pojo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Metadata {
    private String id;
    private String versionsDeleted;
    private String createdAt;
    @JsonAlias({ "private" })
    private String privates;
    private String parentId;
}
