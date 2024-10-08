package updateMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateRequestPojo {
    @Getter
    private String name;
    @Getter
    private String job;
}
