package postMethodTests.RegisterMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuccessRegisterPojo {
    @Getter
    private Integer id;
    @Getter
    private String token;
}
