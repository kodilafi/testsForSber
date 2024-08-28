package postMethodTests.CreateMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateRequestPojo {
    @Getter
    private String name;
    @Getter
    private String job;
}
