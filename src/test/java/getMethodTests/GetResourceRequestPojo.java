package getMethodTests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetResourceRequestPojo {
    @Getter
    private Integer id;
    @Getter
    private String name;
    @Getter
    private Integer year;
    @Getter
    private String color;
    @Getter
    private String pantone_value;
}
