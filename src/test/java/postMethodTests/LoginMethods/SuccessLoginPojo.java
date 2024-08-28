package postMethodTests.LoginMethods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuccessLoginPojo {
    @Getter
    private String token;
}
