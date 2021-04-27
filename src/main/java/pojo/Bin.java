package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Bin {
    private Record record;
    private Metadata metadata;
    private String message;
}
