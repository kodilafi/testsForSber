package postMethodTests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EnterPojo {
    @Getter
    private String email;
    @Getter
    private String password;
}
